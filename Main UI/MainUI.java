/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package processmanager;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.OperationNotSupportedException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Ghaith,3laa
 */
public class MainUI extends javax.swing.JFrame {

    private enum QueueTypes {
        PriorityQueue, FCFS, Roundrobin, SJF
    }
    private boolean prioritzed = true;
    private QueueTypes scheduleType = null;
    private boolean preemptive = false;

    private boolean paused;
    private boolean stepClicked = false;
    private boolean stopClicked = false;
    private boolean restartClicked = false;

    private int totalTAT = 0;
    private int totalWT = 0;

    private BufferedImage img;

    /**
     * Creates new form MainUI
     */
    public MainUI() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        inputTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        RTSButton = new javax.swing.JButton();
        stepButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ISButton = new javax.swing.JButton();
        preemtivityPicker = new javax.swing.JComboBox<>();
        queuePicker = new javax.swing.JComboBox<>();
        quantomBox = new javax.swing.JSpinner();
        clearButton = new javax.swing.JButton();
        pauseButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        restartButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        AVG_TAT_box = new javax.swing.JTextField();
        AVG_WT_box = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Process scheduler");
        setMinimumSize(new java.awt.Dimension(1200, 741));

        inputTable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        inputTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Short((short) 1), null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Execution time", "Arrival time", "Priority", "Turn-around time", "Waiting time", "Response time", "Departure time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Short.class, java.lang.Short.class, java.lang.Short.class, java.lang.Short.class, java.lang.Short.class, java.lang.Short.class, java.lang.Short.class, java.lang.Short.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        inputTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        inputTable.setRowHeight(25);
        inputTable.setSurrendersFocusOnKeystroke(true);
        jScrollPane1.setViewportView(inputTable);
        inputTable.getAccessibleContext().setAccessibleDescription("");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                jPanel1AncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel1.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                jPanel1AncestorResized(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 219, Short.MAX_VALUE)
        );

        RTSButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        RTSButton.setText("Run Real Time Simulation");
        RTSButton.setEnabled(false);
        RTSButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RTSButtonActionPerformed(evt);
            }
        });

        stepButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/processmanager/icons8-forward-40.png"))); // NOI18N
        stepButton.setEnabled(false);
        stepButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stepButtonActionPerformed(evt);
            }
        });

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/processmanager/icons8-plus-24.png"))); // NOI18N
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/processmanager/icons8-minus-24.png"))); // NOI18N
        removeButton.setEnabled(false);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Quantom Time:");
        jLabel1.setEnabled(false);

        ISButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ISButton.setText("Run Instant Simulation");
        ISButton.setEnabled(false);
        ISButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISButtonActionPerformed(evt);
            }
        });

        preemtivityPicker.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        preemtivityPicker.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Choose preemptivity", "non-preemtive", "preemptive" }));
        preemtivityPicker.setEnabled(false);
        preemtivityPicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preemtivityPickerActionPerformed(evt);
            }
        });

        queuePicker.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        queuePicker.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Choose schedulning algorithm", "Priority queue", "FCFS", "Roundrobin", "SJF" }));
        queuePicker.setToolTipText("");
        queuePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queuePickerActionPerformed(evt);
            }
        });

        quantomBox.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        quantomBox.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)1), Short.valueOf((short)1), Short.valueOf((short)50), Short.valueOf((short)1)));
        quantomBox.setEnabled(false);

        clearButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        clearButton.setText("Clear table");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        pauseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/processmanager/icons8-pause-80.png"))); // NOI18N
        pauseButton.setEnabled(false);
        pauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseButtonActionPerformed(evt);
            }
        });

        stopButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/processmanager/icons8-stop-40.png"))); // NOI18N
        stopButton.setEnabled(false);
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        restartButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/processmanager/icons8-restart-40.png"))); // NOI18N
        restartButton.setEnabled(false);
        restartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("AVG turn-around time:");

        AVG_TAT_box.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        AVG_TAT_box.setFocusable(false);

        AVG_WT_box.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        AVG_WT_box.setFocusable(false);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("AVG waiting time:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1133, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AVG_TAT_box, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42))
                            .addComponent(preemtivityPicker, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(queuePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AVG_WT_box, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(quantomBox, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stopButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(restartButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stepButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RTSButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ISButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(AVG_WT_box, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(AVG_TAT_box, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(restartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(pauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(queuePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(quantomBox, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ISButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(preemtivityPicker, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 290, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RTSButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stepButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void queuePickerActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        String scheduleTypeTxt = queuePicker.getSelectedItem().toString();
        if (scheduleTypeTxt.equals("Roundrobin")) {
            if (prioritzed) {
                inputTable.removeColumn(inputTable.getColumnModel().getColumn(3));
                prioritzed = false;
            }
            quantomBox.setEnabled(true);
            jLabel1.setEnabled(true);
            scheduleType = QueueTypes.Roundrobin;
            preemtivityPicker.setEnabled(false);
            preemtivityPicker.setSelectedIndex(0);
            ISButton.setEnabled(true);
            RTSButton.setEnabled(true);

            return;
        }
        if (scheduleTypeTxt.equals("FCFS")) {
            if (prioritzed) {
                inputTable.removeColumn(inputTable.getColumnModel().getColumn(3));
                prioritzed = false;
            }
            quantomBox.setEnabled(false);
            jLabel1.setEnabled(false);
            scheduleType = QueueTypes.FCFS;
            preemtivityPicker.setEnabled(false);
            preemtivityPicker.setSelectedIndex(0);
            ISButton.setEnabled(true);
            RTSButton.setEnabled(true);

            return;
        }
        if (scheduleTypeTxt.equals("Priority queue")) {
            if (!prioritzed) {
                inputTable.addColumn(new TableColumn(3));
                inputTable.getColumnModel().moveColumn(7, 3);
                prioritzed = true;
            }
            quantomBox.setEnabled(false);
            jLabel1.setEnabled(false);
            scheduleType = QueueTypes.PriorityQueue;
            preemtivityPicker.setEnabled(true);
            preemtivityPicker.setSelectedIndex(0);
            return;
        }
        if (scheduleTypeTxt.equals("SJF")) {
            if (prioritzed) {
                inputTable.removeColumn(inputTable.getColumnModel().getColumn(3));
                prioritzed = false;
            }
            quantomBox.setEnabled(false);
            jLabel1.setEnabled(false);
            scheduleType = QueueTypes.SJF;
            preemtivityPicker.setEnabled(true);
            preemtivityPicker.setSelectedIndex(0);
            return;
        } else {
            scheduleType = null;
            preemtivityPicker.setSelectedIndex(0);
            preemtivityPicker.setEnabled(false);
        }
        throw new IllegalStateException("non defined queue type!");


    }                                           
    private void prepareSimulation(boolean instant) {
        if (inputTable.isEditing()) {
            inputTable.getCellEditor().stopCellEditing();
        }
        DefaultTableModel model = (DefaultTableModel) this.inputTable.getModel();
        OpQueue queue;
        switch (scheduleType) {
            case FCFS -> {
                queue = new FCFSQ();
            }
            case PriorityQueue -> {
                if (preemptive) {
                    queue = new PreemptivePriorityQ();
                } else {
                    queue = new PriorityQ();
                }
            }
            case Roundrobin -> {
                queue = new RoundRobin(Integer.parseInt(quantomBox.getValue().toString()));
            }
            case SJF -> {
                if (preemptive) {
                    queue = new PreemptiveSJFQ();
                } else {
                    queue = new SJFQ();
                }
            }
            default -> {

                queue = null;
            }
        }

        for (int i = 0; i < model.getRowCount(); i++) {
            Operation op;
            try {
                if (prioritzed) {
                    op = new Operation(i + 1, Integer.parseInt(model.getValueAt(i, 2).toString()), Integer.parseInt(model.getValueAt(i, 1).toString()), Integer.parseInt(model.getValueAt(i, 3).toString()));
                } else {
                    op = new Operation(i + 1, Integer.parseInt(model.getValueAt(i, 2).toString()), Integer.parseInt(model.getValueAt(i, 1).toString()));
                }
                queue.enqueue(op);

            } catch (IllegalArgumentException | NullPointerException e) {
                JOptionPane.showMessageDialog(new JFrame(), "one or more cells are empty or not excpected at line " + (i + 1), "ERROR", JOptionPane.ERROR_MESSAGE);

                return;
            }
        }

        Simulation sim = Simulation.getInstance(queue, instant);
        img = sim.render();
        repaintSimulation();
        totalTAT = 0;
        totalWT = 0;
        queue.iterate().forEachRemaining((t) -> {

            int id = t.getID();
            int tat = t.getTATime();
            int wt = t.getWaiting();
            int rt = t.getResponseTime();
            model.setValueAt(tat, id - 1, 4);
            model.setValueAt(wt, id - 1, 5);
            model.setValueAt(rt - t.getExecutionTime(), id - 1, 6);
            model.setValueAt(rt, id - 1, 7);
            totalTAT += tat;
            totalWT += wt;

        });

        AVG_TAT_box.setText(Float.toString((float) totalTAT / inputTable.getRowCount()));
        AVG_WT_box.setText(Float.toString((float) totalWT / inputTable.getRowCount()));
        if (!instant) {
            Thread RTThread = new Thread(() -> {
                while (true) {

                    try {
                        for (int i = 0; i < 10; i++) {
                            if (stopClicked) {
                                stepClicked = false;
                                return;
                            }
                            if (restartClicked) {
                                prepareSimulation(false);
                                return;
                            }
                            Thread.sleep(100);
                        }

                        while (paused) {
                            if (stepClicked) {
                                sim.step();
                                stepClicked = false;
                            }
                            if (stopClicked) {
                                stepClicked = false;
                                return;
                            }
                            if (restartClicked) {
                                prepareSimulation(false);
                                restartClicked = false;
                                return;
                            }

                        }
                        sim.step();
                    } catch (OperationNotSupportedException | InterruptedException ex) {
                        Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    img = sim.render();
                    repaintSimulation();
                    totalTAT = 0;
                    totalWT = 0;
                    queue.iterate().forEachRemaining((t) -> {

                        int id = t.getID();
                        int tat = t.getTATime();
                        int wt = t.getWaiting();
                        int rt = t.getResponseTime();
                        model.setValueAt(tat, id - 1, 4);
                        model.setValueAt(wt, id - 1, 5);
                        model.setValueAt(rt - t.getExecutionTime(), id - 1, 6);
                        model.setValueAt(rt, id - 1, 7);
                        totalTAT += tat;
                        totalWT += wt;

                    });

                    AVG_TAT_box.setText(Integer.toString(totalTAT / inputTable.getRowCount()));
                    AVG_WT_box.setText(Integer.toString(totalWT / inputTable.getRowCount()));
                }

            });
            RTThread.start();
            paused = false;
            pauseButton.setEnabled(true);
            stopButton.setEnabled(true);
            restartButton.setEnabled(true);
            clearButton.setEnabled(false);
            preemtivityPicker.setEnabled(false);
            queuePicker.setEnabled(false);
            quantomBox.setEnabled(false);
            jLabel1.setEnabled(false);
            inputTable.setEnabled(false);
            ISButton.setEnabled(false);
        }
    }
    private void ISButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        prepareSimulation(true);
    }                                        

    private void RTSButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        prepareSimulation(false);
    }                                         

    private void pauseButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if (paused) {
            paused = false;
            pauseButton.setIcon(new ImageIcon("src/processmanager/icons8-pause-80.png"));
            stepButton.setEnabled(false);
            inputTable.setEnabled(false);
            return;
        }

        paused = true;
        pauseButton.setIcon(new ImageIcon("src/processmanager/icons8-play-80.png"));
        stepButton.setEnabled(true);
        inputTable.setEnabled(true);


    }                                           

    private void restartButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        restartClicked = true;
    }                                             

    private void stepButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        stepClicked = true;
    }                                          

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        stopClicked = true;
        pauseButton.setEnabled(false);
        stopButton.setEnabled(false);
        restartButton.setEnabled(false);
        clearButton.setEnabled(true);
        preemtivityPicker.setEnabled(true);
        queuePicker.setEnabled(true);
        inputTable.setEnabled(true);
        ISButton.setEnabled(true);
        if (scheduleType == QueueTypes.Roundrobin) {
            quantomBox.setEnabled(false);
            jLabel1.setEnabled(false);
        }
    }                                          


    private void preemtivityPickerActionPerformed(java.awt.event.ActionEvent evt) {                                                  

        if (preemtivityPicker.getSelectedItem().toString().equals("--Choose preemptivity")) {
            ISButton.setEnabled(false);
            RTSButton.setEnabled(false);
            preemptive = false;
        } else {

            ISButton.setEnabled(true);
            RTSButton.setEnabled(true);
            preemptive = preemtivityPicker.getSelectedItem().toString().equals("preemptive");
        }
    }                                                 

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        int rowcnt = inputTable.getRowCount();
        
        DefaultTableModel model = (DefaultTableModel) this.inputTable.getModel();
        int[] rows = inputTable.getSelectedRows();
        if (rows.length == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "select rows to be deleted", "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }
        for (int i = 0; i < rows.length; i++) {
            model.removeRow(rows[i] - i);

        }

        for (int i = Arrays.stream(rows).min().getAsInt() + 1; i <= inputTable.getRowCount(); i++) {
            model.setValueAt(i, i - 1, 0);
        }
        rowcnt = inputTable.getRowCount();
        if(rowcnt < 1)  
            model.addRow(new String[]{Integer.toString(rowcnt + 1), null, null, null, null, null, null, null, null});
        
        if(rowcnt < 2)  {
            removeButton.setEnabled(false);
            
        }
    }                                            

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        DefaultTableModel model = (DefaultTableModel) this.inputTable.getModel();
        model.setNumRows(0);
        jPanel1.updateUI();
        AVG_TAT_box.setText("");
        AVG_WT_box.setText("");
        model.addRow(new String[]{"1", null, null, null, null, null, null, null, null});
        removeButton.setEnabled(false);
    }                                           

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        int rowcnt = inputTable.getRowCount();

        DefaultTableModel model = (DefaultTableModel) inputTable.getModel();

        removeButton.setEnabled(true);
        model.addRow(new String[]{Integer.toString(rowcnt + 1), null, null, null, null, null, null, null, null});

    }                                         

    private void repaintSimulation() {
        Graphics graph = jPanel1.getGraphics();
        graph.drawImage(img, 0, 0, null);
        graph.dispose();
    }

    private void jPanel1AncestorResized(java.awt.event.HierarchyEvent evt) {                                        
        repaintSimulation();
    }                                       

    private void jPanel1AncestorMoved(javax.swing.event.AncestorEvent evt) {                                      
        repaintSimulation();
    }                                     

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
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify                     
    private javax.swing.JTextField AVG_TAT_box;
    private javax.swing.JTextField AVG_WT_box;
    private javax.swing.JButton ISButton;
    private javax.swing.JButton RTSButton;
    private javax.swing.JButton addButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JTable inputTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pauseButton;
    private javax.swing.JComboBox<String> preemtivityPicker;
    private javax.swing.JSpinner quantomBox;
    private javax.swing.JComboBox<String> queuePicker;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton restartButton;
    private javax.swing.JButton stepButton;
    private javax.swing.JButton stopButton;
    // End of variables declaration                   
}
