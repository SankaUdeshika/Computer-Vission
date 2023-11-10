/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainP;


import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

 class FaceDetection {

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Path to the XML file containing the haarcascades for face detection
        String faceCascadePath = "path/to/haarcascade_frontalface_default.xml";

        // Load the cascade classifier
        CascadeClassifier faceCascade = new CascadeClassifier();
        faceCascade.load(faceCascadePath);

        // Path to the input image
        String imagePath = "C:\\Users\\sanka\\OneDrive\\Documents\\NetBeansProjects\\ComputerVission1\\src\\MainP\\IMG_20231009_000440.jpg";

        // Read the input image
        Mat image = Imgcodecs.imread(imagePath);

        // Convert the image to grayscale for face detection
        Mat grayImage = new Mat();
        Imgproc.cvtColor(image, grayImage, Imgproc.COLOR_BGR2GRAY);
        Imgproc.equalizeHist(grayImage, grayImage);

        // Detect faces in the image
        MatOfRect faceDetections = new MatOfRect();
        faceCascade.detectMultiScale(grayImage, faceDetections);

        System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));

        // Draw rectangles around the detected faces
        for (Rect rect : faceDetections.toArray()) {
            Imgproc.rectangle(image, rect.tl(), rect.br(), new Scalar(0, 255, 0), 3);
        }

        // Save the output image with detected faces
        String outputImagePath = "C:\\Users\\sanka\\OneDrive\\Documents\\NetBeansProjects\\ComputerVission1\\src\\MainP\\IMG_20231009_000440.jpg";
        Imgcodecs.imwrite(outputImagePath, image);
    }
}

