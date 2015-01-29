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
import java.util.Scanner;

/**
 *
 * @author test
 */
public class TaiLogicUnit {

    public List<TaiNode> getChildren(TaiNode parentNode, List<TaiNode> tree) {
        List<TaiNode> list = new ArrayList<>();
        for (TaiNode treeNode : tree) {
            if (treeNode.getParentId() == parentNode.getId()) {
                list.add(treeNode);
            }
        }
        return list;
    }

    public String javaObjectToJSON(List<TaiNode> tree) {
        return "";
    }

    public List<TaiNode> fileToTaiTree(File inFile) {
        List<TaiNode> list = new ArrayList<>();

        return list;
    }

    public TaiNode findNode(int id, List<TaiNode> tree) {
        for (TaiNode taiNode : tree) {
            if (taiNode.getId() == id) {
                return taiNode;
            }
        }
        return null;
    }

    public List<TaiNode> getPath(TaiNode node, List<TaiNode> tree) {
        List<TaiNode> list = new ArrayList<>();
        return list;
    }

    public void printTree(List<TaiNode> tree) {
        TaiNode root = findNode(-1, tree);
        List<TaiNode> rooNodes = getRootNodes(tree);
        List<TaiNode> leafNodes = getLeafNodes(tree);
        System.out.println("Root Nodes:");
        for (TaiNode taiNode : rooNodes) {
            System.out.println("   " + taiNode.getQuestion());
        }
        System.out.println("Leaf Nodes:");
        for (TaiNode taiNode : leafNodes) {
            System.out.println("   " + taiNode.getResult());
        }
    }

    private List<TaiNode> getRootNodes(List<TaiNode> tree) {
        List<TaiNode> list = new ArrayList<>();
        for (TaiNode taiNode : tree) {
            if (!taiNode.isIsEndNode()) {
                list.add(taiNode);
            }
        }
        return list;
    }

    private List<TaiNode> getLeafNodes(List<TaiNode> tree) {
        List<TaiNode> list = new ArrayList<>();
        for (TaiNode taiNode : tree) {
            if (taiNode.isIsEndNode()) {
                list.add(taiNode);
            }
        }
        return list;
    }

    public void executeTree(List<TaiNode> tree) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        TaiNode root = findNode(-1, tree);
        executeRecursive(root,tree,sc);
    }

    private void executeRecursive(TaiNode node, List<TaiNode> tree, Scanner sc) {
        if(!node.isIsEndNode()){
            System.out.println(node.getQuestion());
            List<TaiNode> children = getChildren(node, tree);
            for (int i = 0; i < children.size(); i++) {
                int option = i+1;
                System.out.println(option+". "+children.get(i).getAnswer());
            }
            System.out.println("Input:");
            int sol = Integer.valueOf(sc.nextLine());
            sol--;
            TaiNode answerNode = children.get(sol);
            executeRecursive(answerNode, tree, sc);
        }else{
            System.out.println(node.getResult());
        }
    }

}
