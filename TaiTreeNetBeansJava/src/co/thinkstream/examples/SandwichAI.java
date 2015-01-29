/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.thinkstream.examples;

import co.thinkstream.main.TaiLogicUnit;
import co.thinkstream.struct.TaiNode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author test
 */
public class SandwichAI {
    // root
    // /  \
    //1    2
    //   /   \
    //  3      4
    // / \    / \
    // 5  6   7  8
    //   / \
    //   9 10
    public static void main(String[] args){
        List<TaiNode> list = new ArrayList<>();
        TaiNode rt = new TaiNode();
        rt.setQuestion("Do you have peanut butter, jelly and bread?");
        rt.setIsEndNode(false);
        rt.setId(-1);
        rt.setParentId(-2);
        
        TaiNode one = new TaiNode();
        one.setAnswer("NO");
        one.setResult("Go get the required items and start over");
        one.setIsEndNode(true);
        one.setParentId(rt.getId());
        
        TaiNode two = new TaiNode();
        two.setAnswer("YES");
        two.setQuestion("Do you have a butterknife?");
        two.setIsEndNode(false);
        two.setParentId(rt.getId());
        
        TaiNode three = new TaiNode();
        three.setAnswer("NO");
        three.setIsEndNode(false);
        three.setParentId(two.getId());
        three.setQuestion("Do you have spoon?");
        
        TaiNode four = new TaiNode();
        four.setAnswer("YES");
        four.setIsEndNode(false);
        four.setParentId(two.getId());
        four.setQuestion("Do you have a plate?");
        
        TaiNode seven = new TaiNode();
        seven.setIsEndNode(true);
        seven.setParentId(four.getId());
        seven.setAnswer("YES");
        seven.setResult("Butter your bread on the plate with your butter knife.");
        
        TaiNode eight = new TaiNode();
        eight.setIsEndNode(true);
        eight.setParentId(four.getId());
        eight.setAnswer("NO");
        eight.setResult("Grab a napkin and butter your bread on the napkin with your butter knife.");
        
        TaiNode five = new TaiNode();
        five.setIsEndNode(true);
        five.setAnswer("NO");
        five.setParentId(three.getId());
        five.setResult("You will need something to butter your sandwich");
        
        TaiNode six = new TaiNode();
        six.setIsEndNode(false);
        six.setAnswer("YES");
        six.setQuestion("Do you have a plate?");
        six.setParentId(three.getId());
        //
         TaiNode nine = new TaiNode();
        nine.setIsEndNode(true);
        nine.setParentId(six.getId());
        nine.setAnswer("YES");
        nine.setResult("Butter your bread on the plate with the end of your spoon.");
        
        TaiNode ten = new TaiNode();
        ten.setIsEndNode(true);
        ten.setParentId(six.getId());
        ten.setAnswer("NO");
        ten.setResult("Grab a napkin and butter your bread on the napkin with the end of your spoon.");
        
        
        
        list.add(rt);
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        list.add(five);
        list.add(six);
        list.add(seven);
        list.add(eight);
        list.add(nine);
        list.add(ten);
        
        TaiLogicUnit logic = new TaiLogicUnit();
//        logic.printTree(list);
        logic.executeTree(list);
        
        
    }
}
