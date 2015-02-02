/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.thinkstream.examples;

import co.thinkstream.main.TaiLogicUnit;
import co.thinkstream.struct.TaiNode;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author test
 */
public class LoadAndRunJSON {

    public LoadAndRunJSON() {
        System.out.println("Loading file");
        TaiLogicUnit logic = new TaiLogicUnit();
        List<TaiNode> nodeTree;
        try {
            nodeTree = logic.jsonToJavaTree(new File("mood.txt"));
            logic.executeTree(nodeTree);
        } catch (IOException ex) {
            Logger.getLogger(LoadAndRunJSON.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {

        new LoadAndRunJSON();

    }

}
