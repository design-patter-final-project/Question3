/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Question3 extends javax.swing.JFrame {
    public static List<Employee> employeeList = new ArrayList<Employee>();
    public Question3() {
        initComponents();
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
            String nn = name.getText();
            Double n = Double.parseDouble(salary.getText());
            TreeSelectionModel smd = jTree1.getSelectionModel();

        if (smd.getSelectionCount() > 0) {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree1.getSelectionPath().getLastPathComponent();
            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(name.getText());
            selectedNode.add(newNode);
            DefaultTreeModel model = (DefaultTreeModel) jTree1.getModel();
            model.reload();
            String str = selectedNode.getUserObject().toString();
            Employee newEmp = new Employee(nn, n, "adsdf");
            employeeList.add(newEmp);
            System.out.println(employeeList);
            int op = 0;
            for (int i = 0; i < employeeList.size(); i++) {
                if (str.equalsIgnoreCase(employeeList.get(i).getName())){
                    op = i;
                }
            }
                employeeList.get(op).add(newEmp);
                Double ss = 0.0;
                if (employeeList.get(op).getSubordinateSalary()!=null){
                    ss = employeeList.get(op).getSubordinateSalary();
                }else{
                    ss = 0.0;
                }
                label.setText("Name: " + nn + " Salary: " + n + " S. Salary: " + ss);
            }
    }

    private void initComponents() {
        setSize(600, 500);
        mutableTreeNode = new DefaultMutableTreeNode("Company");
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree(mutableTreeNode);
        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        salary = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jTree1);

        jLabel1.setText("Name");

        jLabel2.setText("Salary");
        jButton1.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jTree1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clicke(e);
            }
        });

        label.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        label.setText(":");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(88, 88, 88).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(layout.createSequentialGroup().addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(salary, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGap(0, 51, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE).addGroup(layout.createSequentialGroup().addGap(95, 95, 95).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2).addComponent(salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(28, 28, 28).addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(28, 28, 28).addComponent(label).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
        setLocationRelativeTo(null);
    }
    public void clicke(MouseEvent e){

        TreeSelectionModel smd = jTree1.getSelectionModel();
        if(smd.getSelectionCount() > 0){
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree1.getSelectionPath().getLastPathComponent();
            name.setText(selectedNode.getUserObject().toString());
            String str = selectedNode.getUserObject().toString();
            int op = 0;
            for (int i = 0; i < employeeList.size(); i++) {
                if (str.equalsIgnoreCase(employeeList.get(i).getName())){
                    op = i;
                }
            }
            Double ss,salaryH = 0.0;
            if (employeeList.size() != 0){
                ss = employeeList.get(op).getSubordinateSalary();
                salaryH = employeeList.get(op).getSalary();
            }else{
                ss = 0.0;
                salaryH = 0.0;
            }
            label.setText("Name: " + str + " Salary: " + salaryH + " S. Salary: " + ss);
        }
    }
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Question3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Question3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Question3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Question3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Question3().setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.tree.DefaultMutableTreeNode mutableTreeNode;
    private javax.swing.JTree jTree1;
    private javax.swing.JLabel label;
    private javax.swing.JTextField name;
    private javax.swing.JTextField salary;
    // End of variables declaration
}