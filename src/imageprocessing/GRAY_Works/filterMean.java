
package imageprocessing.GRAY_Works;

import cezeri.matrix.CMatrix;

public class filterMean
{
    public static void main(String[] args)
    {
        CMatrix cm = CMatrix.getInstance()
                .imread("images//lena_gray.gif")
                .rgb2gray()
                .imshow();

        int[][] d = cm.toIntArray2D();
        int w = d.length;
        int h = d[0].length;
        int[][] temp = new int[w][h];

        int window = 9;
        int sum = 0;

        for (int i = 1; i < w - 1; i++)
        {
            for (int j = 1; j < h - 1; j++)
            {
                for (int k = -1; k <= 1; k++)
                {
                    for (int l = -1; l <= 1; l++)
                    {
                        sum += d[i + k][j + l];
                    }
                }

                temp[i][j] = sum / window;
                sum = 0;
            }
        }

        cm.setArray(temp).map(0, 255).imshow();
        

    }
}
