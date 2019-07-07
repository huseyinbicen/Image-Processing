package imageprocessing.Final_Exam;

import cezeri.matrix.CMatrix;

public class Apply_aFunction
{

    public static void main(String[] args)
    {
        CMatrix cm = CMatrix.getInstance()
                .imread("images//lena_color.gif")
                .rgb2gray()
                .minusScalar(0)
                .imshow();
     
        cm.pow(2).multiplyScalar(3)
                .minus(cm.powerByScalar(4))
                .imshow();
        
       
    }
}
