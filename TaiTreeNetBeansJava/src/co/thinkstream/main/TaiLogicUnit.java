/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.thinkstream.main;

import co.thinkstream.struct.TaiNode;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author test
 */
public class TaiLogicUnit {
    public List<TaiNode> getChildren(TaiNode node, List<TaiNode> tree){
        List<TaiNode> list = new ArrayList<>();
        for (TaiNode treeNode : tree) {
            if(treeNode.getId()==node.getParentId()){
                list.add(node);
            }
        }
        return list;
    }
    
    public String javaObjectToJSON(List<TaiNode> list){
        return "";
    }
    public List<TaiNode> fileToTaiTree(File inFile){
         List<TaiNode> list = new ArrayList<>();
         
         return list;
    }
    
}
