/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkp;

import javax.swing.JComboBox;

/**
 *
 * @author rezabdullah
 */
public class SetComboBoxValue {
    private int index;
    private String name;

    public SetComboBoxValue(int pindex, String pName) {
        this.index = pindex;
        this.name = pName;
    }

    public int GetIndex() {
        return this.index;
    }

    public String GetName() {
        return this.name;
    }

    public int SetIndex(int pindex) {
        this.index = pindex;
        return pindex;
    }

    public String SetName(String pName) {
        this.name = pName;
        return pName;
    }


    // This will be used internally by JComboBox as the label to be displayed.
    @Override
    public String toString() {
        return name;
    }

    // to get the Index of Combobox depends on ComboItem Class
    public static int getIndexById(JComboBox combo, int id) {

        for (int i = 1; i < combo.getItemCount(); i++) {
            try {
                SetComboBoxValue c = (SetComboBoxValue) combo.getItemAt(i);
                int tempId = c.GetIndex();
                if (tempId == id) {
                    return i;
                }
            } catch (Exception e) {

            }
        }
        return 0;
    }
}
