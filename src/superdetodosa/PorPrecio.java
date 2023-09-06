package superdetodosa;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import superdetodosa.modelo.Producto;

public class PorPrecio extends javax.swing.JInternalFrame {
    DefaultTableModel tab = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    public PorPrecio() {
        initComponents();
        armarCabecera();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlEntre = new javax.swing.JLabel();
        jtPrecio1 = new javax.swing.JTextField();
        jlY = new javax.swing.JLabel();
        jtPrecio2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtablePrecio = new javax.swing.JTable();

        setClosable(true);
        setTitle("Busqueda por precio");

        jlEntre.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jlEntre.setForeground(new java.awt.Color(255, 0, 0));
        jlEntre.setText("Entre $:");

        jtPrecio1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtPrecio1KeyReleased(evt);
            }
        });

        jlY.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jlY.setForeground(new java.awt.Color(255, 0, 0));
        jlY.setText("Y");

        jtPrecio2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtPrecio2KeyReleased(evt);
            }
        });

        jtablePrecio.setForeground(new java.awt.Color(255, 0, 0));
        jtablePrecio.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtablePrecio);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlEntre)
                        .addGap(31, 31, 31)
                        .addComponent(jtPrecio1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jlY)
                        .addGap(51, 51, 51)
                        .addComponent(jtPrecio2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(260, 260, 260))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEntre)
                    .addComponent(jtPrecio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlY)
                    .addComponent(jtPrecio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtPrecio2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPrecio2KeyReleased

        borrarFilas();
        try {
            double pMin, pMax; 
            if (jtPrecio1.getText().trim().equals("") || jtPrecio2.getText().trim().equals("")) {
                pMin = 0;
                pMax = 0;
            } else {
                pMin = Double.parseDouble(jtPrecio1.getText().trim());
                pMax = Double.parseDouble(jtPrecio2.getText().trim());
            }

            for (Producto elem : Menu.productos) {
                if (elem.getPrecio() >= pMin && elem.getPrecio() <= pMax) {
                    
                    tab.addRow(new Object[]{
                        elem.getCodigo(),
                        elem.getDescripcion(),
                        elem.getPrecio(),
                        elem.getStock()
                    });
                }
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Datos incorrectos: deben ser numeros");
            borrarFilas();
            jtPrecio1.setText("");
            jtPrecio2.setText("");
        }
    }//GEN-LAST:event_jtPrecio2KeyReleased

    private void jtPrecio1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPrecio1KeyReleased
        
        borrarFilas();
        try {
            double pMin, pMax;
            
            if (jtPrecio1.getText().trim().equals("") || jtPrecio2.getText().trim().equals("")) {
                pMin = 0;
                pMax = 0;
                
            } else {
                pMin = Double.parseDouble(jtPrecio1.getText().trim());
                pMax = Double.parseDouble(jtPrecio2.getText().trim());
            }

            for (Producto elem : Menu.productos) {
                if (elem.getPrecio() >= pMin && elem.getPrecio() <= pMax) {
                    
                  tab.addRow(new Object[]{
                        elem.getCodigo(),
                        elem.getDescripcion(),
                        elem.getPrecio(),
                        elem.getStock()
                    });
                }
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Datos incorrectos: deben ingresar numeros");
            borrarFilas();
            jtPrecio1.setText("");
            jtPrecio2.setText("");
        }
    }//GEN-LAST:event_jtPrecio1KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlEntre;
    private javax.swing.JLabel jlY;
    private javax.swing.JTextField jtPrecio1;
    private javax.swing.JTextField jtPrecio2;
    private javax.swing.JTable jtablePrecio;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {
        tab.addColumn("Codigo");
        tab.addColumn("Descripcion");
        tab.addColumn("Precio");
        tab.addColumn("Stock");
        jtablePrecio.setModel(tab);

    }

    
    private void borrarFilas() {
        
        int f = jtablePrecio.getRowCount() - 1;
        
        for (; f >= 0; f--) {
            tab.removeRow(f);
        }

    }

}
