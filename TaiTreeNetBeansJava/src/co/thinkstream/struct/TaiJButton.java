/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.thinkstream.struct;

import javax.swing.JButton;

/**
 *
 * @author test
 */
public class TaiJButton extends JButton{
    private TaiNode node;
    public TaiJButton(TaiNode node){
        this.node = node;
    }

    /**
     * @return the node
     */
    public TaiNode getNode() {
        return node;
    }

    /**
     * @param node the node to set
     */
    public void setNode(TaiNode node) {
        this.node = node;
    }
}
