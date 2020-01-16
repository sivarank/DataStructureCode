package dynamicProgramming;

import java.util.Arrays;

public class BoxesStacking {

	public static void main(String[] args) {
		BoxesStacking bs = new BoxesStacking();
        Dimension input[] = { new Dimension(3, 2, 5), new Dimension(1, 2, 4) };
        int maxHeight = bs.maxHeight(input);
        System.out.println("Max height is " + maxHeight);
        assert 11 == maxHeight;
	}

	private int maxHeight(Dimension[] input) {
		
		// create all rotations.Make sure length > depth,
		Dimension[] allRotations = new Dimension[3*input.length];
		for(int i=0, j=0 ;i<input.length;i++) {
			// select first height 
			allRotations[j++] = Dimension.createDimension(input[i].height, input[i].length, input[i].width);
			allRotations[j++] = Dimension.createDimension(input[i].length, input[i].height, input[i].width);
			allRotations[j++] = Dimension.createDimension(input[i].width, input[i].length, input[i].height);
		}
		Arrays.sort(allRotations);
		
		int[] mem = new int[3*input.length];
		
		for(int i=0; i<mem.length; i++) {
			mem[i] = allRotations[i].height;
		}
		for(int i = 1; i<mem.length; i++) {
			int max = Integer.MIN_VALUE;
			for(int j=0; j<i; j++) {
				if(allRotations[i].length <allRotations[j].length && allRotations[i].width < allRotations[j].width) {
					max = Math.max(max, allRotations[i].height+mem[j]);					
				}
				mem[i] = max;
			}
		}
		return mem[mem.length-1];
	}

}

/**
 * Utility class to hold dimensions
 * @author tusroy
 *
 */
class Dimension implements Comparable<Dimension> {
    int height;
    int length;
    int width;

    Dimension(int height, int length, int width) {
        this.height = height;
        this.length = length;
        this.width = width;
    }

    Dimension() {
    }

    static Dimension createDimension(int height, int side1, int side2) {
        Dimension d = new Dimension();
        d.height = height;
        if (side1 >= side2) {
            d.length = side1;
            d.width = side2;
        } else {
            d.length = side2;
            d.width = side1;
        }
        return d;
    }

    /**
     * Sorts by base area(length X width)
     */
    @Override
    public int compareTo(Dimension d) {
        if (this.length * this.width >= d.length * d.width) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Dimension [height=" + height + ", length=" + length
                + ", width=" + width + "]";
    }
}

