
package imageprocessing.GRAY_Works;

import cezeri.matrix.CMatrix;

public class FindCountOfShape
{
    public static void main(String[] args)
    {
        CMatrix cm = CMatrix.getInstance().imread("images/siyah.png");
        cm.imshow();
        int counter = 0;
        int[][] d = cm.toIntArray2D();
        int[][] newArray = new int[d.length][d[0].length];
        int[][] lastImage = new int[d.length][d[0].length];

        for (int i = 0; i < d.length; i++)
        {
            for (int j = 0; j < d[0].length; j++)
            {
                if (d[i][j] == 255)
                {
                    newArray[i][j] = 0;
                } else if (d[i][j] != 255)
                {

                    newArray[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < d.length; i++)
        {
            for (int j = 0; j < d[0].length; j++)
            {

                if (newArray[i][j] != 0)
                {

                    if (newArray[i][j - 1] == 0 && newArray[i - 1][j] == 0)
                    {
                        counter++;
                    }
                    lastImage[i][j] = counter;
                }
            }
        }

        for (int i = 0; i < newArray.length; i++)
        {
            for (int j = 0; j < newArray[0].length; j++)
            {
                System.out.print(lastImage[i][j]);

            }
            System.out.println("");
        }

        //CMatrix imgShow = CMatrix.getInstance().setArray(newArray).imshow();
        

    }
}
