/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainP;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

class OpenCVExample {

    public static void main(String[] args) {
        // Load the OpenCV library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Read an image from file
        Mat img = Imgcodecs.imread("your_image.jpg");

        // Display the image
        HighGui.imshow("Image", img);

        // Wait for a key press and close the window
        HighGui.waitKey(0);
        HighGui.destroyAllWindows();
    }
}
