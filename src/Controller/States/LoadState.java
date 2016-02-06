package Controller.States;


import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;

import Controller.Controller;

/**
 * Created by Andy on 2/4/2016.
 */
public class LoadState extends State{

    public LoadState(Controller controller)
    {
        super(controller);

    }

    public void tick()
    {

    }

    public void render(Graphics g)
    {

    }

    public static void loadFile(String filepath){
        File inputFile;
        BufferedReader inputReader;

        try{
            inputFile = new File(filepath);
            inputReader = new BufferedReader(new FileReader(inputFile));
            String fileText = inputReader.readLine();
            System.out.println(fileText);


            inputReader.close();

        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }

