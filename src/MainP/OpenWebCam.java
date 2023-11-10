/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainP;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.core.CvType;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfInt4;
import org.opencv.core.MatOfFloat;
import org.opencv.highgui.HighGui;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

 class WebcamExample {
    public static void main(String[] args) {
        // Load the OpenCV library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Create a VideoCapture object for webcam access
        VideoCapture capture = new VideoCapture(0); // 0 represents the default webcam, you can change it if you have multiple webcams

        // Check if the webcam is opened successfully
        if (!capture.isOpened()) {
            System.out.println("Error: Could not open webcam.");
            return;
        }

        // Create a window to display the webcam feed
        HighGui.namedWindow("Webcam", HighGui.WINDOW_NORMAL);

        // Read frames from the webcam
        Mat frame = new Mat();
        while (true) {
            // Capture a frame from the webcam
            capture.read(frame);

            // Check if the frame is empty (end of video stream)
            if (frame.empty()) {
                System.out.println("Error: Frame is empty.");
                break;
            }

            // Perform any image processing if needed

            // Display the frame in the window
            HighGui.imshow("Webcam", frame);

            // Check for a key press and break the loop if the 'ESC' key is pressed
            if (HighGui.waitKey(30) == 27) {
                break;
            }
        }

        // Release the VideoCapture object and close the window
        capture.release();
        HighGui.destroyAllWindows();
    }
}