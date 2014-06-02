/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cbedoy.cbway.viewcontrollers;

import cbedoy.cbway.bussinescontrollers.MasterViewController;
import cbedoy.cbway.interfaces.IGravityServiceDelegate;
import cbedoy.cbway.interfaces.INodeDelegate;
import cbedoy.cbway.interfaces.INodeHandlerDelegate;
import cbedoy.cbway.interfaces.INodeRepresentationDelegate;
import cbedoy.cbway.interfaces.IViewDelegate;
import cbedoy.cbway.interfaces.IWheaterServiceInformationDelegate;
import cbedoy.cbway.services.WeatherKeySet;
import java.util.HashMap;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos
 */
public class MainView extends javax.swing.JFrame implements INodeRepresentationDelegate, IViewDelegate{
    private final DefaultTableModel             defaultTableModel;
    private MasterViewController                masterViewController;
    private INodeHandlerDelegate                nodeHandlerDelegate;
    private INodeDelegate                       nodeDelegate;
    private IWheaterServiceInformationDelegate  wheatherServiceInformationDelegate;
    
    public MainView() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.setColumnIdentifiers(new Object[]{
            WeatherKeySet.COUNTRY,
            WeatherKeySet.LATITUDE,
            WeatherKeySet.LENGTH,
            WeatherKeySet.COST,
            WeatherKeySet.MESSAGE,
            WeatherKeySet.TEMP,
            WeatherKeySet.TEMP_MAX,
            WeatherKeySet.TEMP_MIN,
            WeatherKeySet.HUMIDITY,
            WeatherKeySet.PRESURE,
            WeatherKeySet.SPEED,
            WeatherKeySet.SUNRISE,
            WeatherKeySet.SUNSET
            
            
        });
        dataCenter.setModel(defaultTableModel);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        sName = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        sCost = new javax.swing.JTextField();
        actionSolve = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        sCost1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        sPositionX = new javax.swing.JLabel();
        latitude_view = new javax.swing.JLabel();
        lenght_view = new javax.swing.JLabel();
        country_view = new javax.swing.JLabel();
        city_view = new javax.swing.JLabel();
        state_view = new javax.swing.JLabel();
        delegation_view = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataCenter = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(191, 32, 38));
        jPanel1.setForeground(new java.awt.Color(240, 240, 240));
        jPanel1.setMinimumSize(new java.awt.Dimension(44, 100));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("WHERE ARE YOU?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(1042, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(105, 106, 108));

        sName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sNameActionPerformed(evt);
            }
        });

        addButton.setBackground(new java.awt.Color(255, 255, 255));
        addButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(0, 153, 153));
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        actionSolve.setBackground(new java.awt.Color(255, 255, 255));
        actionSolve.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        actionSolve.setForeground(new java.awt.Color(0, 153, 153));
        actionSolve.setText("Solve");
        actionSolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionSolveActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Country");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("City");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Cost");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sCost, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sCost1)
                    .addComponent(addButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(actionSolve, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sCost1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(actionSolve)
                .addGap(73, 73, 73))
        );

        jPanel3.setBackground(new java.awt.Color(90, 74, 76));
        jPanel3.setForeground(new java.awt.Color(240, 240, 240));

        sPositionX.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sPositionX.setForeground(new java.awt.Color(255, 255, 255));

        latitude_view.setForeground(new java.awt.Color(224, 224, 224));
        latitude_view.setText("jLabel3");

        lenght_view.setForeground(new java.awt.Color(224, 224, 224));
        lenght_view.setText("jLabel3");

        country_view.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        country_view.setForeground(new java.awt.Color(224, 224, 224));
        country_view.setText("jLabel3");

        city_view.setForeground(new java.awt.Color(224, 224, 224));
        city_view.setText("jLabel3");

        state_view.setForeground(new java.awt.Color(224, 224, 224));
        state_view.setText("jLabel3");

        delegation_view.setForeground(new java.awt.Color(224, 224, 224));
        delegation_view.setText("jLabel3");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sPositionX)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lenght_view, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(latitude_view, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(country_view)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(state_view, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(city_view, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(delegation_view, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sPositionX)
                    .addComponent(latitude_view))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lenght_view)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(country_view)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(state_view)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(delegation_view)
                .addGap(7, 7, 7)
                .addComponent(city_view)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        dataCenter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(dataCenter);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Demo V 0.8 CBWAYLib");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel5)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        String country                                  = sName.getText();
        Double cost                                     = Double.parseDouble(sCost.getText());
        nodeDelegate.userSelectedCountryWithCost(country, cost);
        sName.setText(null);
        sCost.setText(null);
        nodeHandlerDelegate.userRequestInformationTable();
    }//GEN-LAST:event_addButtonActionPerformed

    private void actionSolveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionSolveActionPerformed
        IGravityServiceDelegate gravityServiceDelegate  = masterViewController.getGravityServiceDelegate();
        List<Object> dataModel                          = masterViewController.getMasterController().getDataModel();
        gravityServiceDelegate.solveNodes(dataModel);
        nodeHandlerDelegate.userRequestSolution();
    }//GEN-LAST:event_actionSolveActionPerformed

    private void sNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sNameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actionSolve;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel city_view;
    private javax.swing.JLabel country_view;
    private javax.swing.JTable dataCenter;
    private javax.swing.JLabel delegation_view;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel latitude_view;
    private javax.swing.JLabel lenght_view;
    private javax.swing.JTextField sCost;
    private javax.swing.JTextField sCost1;
    private javax.swing.JTextField sName;
    private javax.swing.JLabel sPositionX;
    private javax.swing.JLabel state_view;
    // End of variables declaration//GEN-END:variables

    public void setMasterViewController(MasterViewController masterViewController) {
        this.masterViewController = masterViewController;
    }

    
    @Override
    public void reloadData(HashMap<String, Object> dataModel) {
        
        if(dataModel != null){
            country_view        .setText(dataModel.get("country").toString());
            city_view           .setText(dataModel.get("city").toString());
            delegation_view     .setText(dataModel.get("delegation").toString());
            state_view          .setText(dataModel.get("state").toString());
            latitude_view       .setText(dataModel.get("position_x").toString());
            lenght_view         .setText(dataModel.get("position_y").toString());
            
        }else{
            country_view.setText(null);
            city_view.setText(null);
            state_view.setText(null);
            latitude_view.setText(null);
            lenght_view.setText(null);
            delegation_view.setText(null);
        }
    }

    @Override
    public void reloadTable(HashMap<WeatherKeySet, Object> dataModel) {
        Object[] row = new Object[]{
            dataModel.get(WeatherKeySet.COUNTRY),
            dataModel.get(WeatherKeySet.LATITUDE),
            dataModel.get(WeatherKeySet.LENGTH),
            dataModel.get(WeatherKeySet.COST),
            dataModel.get(WeatherKeySet.MESSAGE),
            dataModel.get(WeatherKeySet.TEMP),
            dataModel.get(WeatherKeySet.TEMP_MAX),
            dataModel.get(WeatherKeySet.TEMP_MIN),
            dataModel.get(WeatherKeySet.HUMIDITY),
            dataModel.get(WeatherKeySet.PRESURE),
            dataModel.get(WeatherKeySet.SPEED),
            dataModel.get(WeatherKeySet.SUNRISE),
            dataModel.get(WeatherKeySet.SUNSET)
        };
        defaultTableModel.addRow(row);
    }
    
    public void setNodeHandlerDelegate(INodeHandlerDelegate nodeHandlerDelegate) {
        this.nodeHandlerDelegate = nodeHandlerDelegate;
    }

    public void setNodeDelegate(INodeDelegate nodeDelegate) {
        this.nodeDelegate = nodeDelegate;
    }

    public void setWheatherServiceInformationDelegate(IWheaterServiceInformationDelegate wheatherServiceInformationDelegate) {
        this.wheatherServiceInformationDelegate = wheatherServiceInformationDelegate;
    }

    @Override
    public void hideView() {
        setVisible(false);
    }

    @Override
    public void reloadView() {
        reloadData(null);
    }

    @Override
    public void showView() {
        setVisible(true);
    }


}
