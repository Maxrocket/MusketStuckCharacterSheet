package musketstuckcharactersheet;

import musketstuckcharactersheet.ui.WeaponListElement;
import musketstuckcharactersheet.ui.ArmourListElement;
import musketstuckcharactersheet.structures.Monster;
import musketstuckcharactersheet.structures.Armour;
import musketstuckcharactersheet.structures.Weapon;
import musketstuckcharactersheet.structures.Attack;
import musketstuckcharactersheet.structures.Character;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import musketstuckcharactersheet.dice.DiceParser;
import musketstuckcharactersheet.onRollFunctions.DoubleOnes;
import musketstuckcharactersheet.ui.ResourceListElement;
import musketstuckcharactersheet.ui.SkillProficiencyListElement;
import musketstuckcharactersheet.ui.TechniqueListElement;
import musketstuckcharactersheet.utils.OnRoll;
import musketstuckcharactersheet.utils.Output;
import musketstuckcharactersheet.utils.XMLElement;
import musketstuckcharactersheet.utils.XMLReader;

public class Window extends javax.swing.JFrame {

    public HashMap<String, JTextField> modRef;
    public HashMap<String, JTextField> statRef;
    public HashMap<String, JLabel> labelRef;

    public HashMap<String, Character> characters;
    public HashMap<String, Monster> monsters;
    public String currentSelection;
    public int currentGrist;
    public ArrayList<ArmourListElement> armourElements;
    public ArrayList<WeaponListElement> attackElements;
    public ArrayList<ResourceListElement> resourceElements;

    public JCanvas healthBar;
    public JSpinner advantage;
    public JTextField prof;
    public JCheckBox discord;
    public JTextArea area;
    public Window window;

    public Window() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        outputCheckbox = new javax.swing.JCheckBox();
        advSpinner = new javax.swing.JSpinner();
        advLabel = new javax.swing.JLabel();
        outputScrollPane = new javax.swing.JScrollPane();
        outputTextArea = new javax.swing.JTextArea();
        mainTabPane = new javax.swing.JTabbedPane();
        characterScrollPane = new javax.swing.JScrollPane();
        characterPanel = new javax.swing.JPanel();
        hpLabel = new javax.swing.JLabel();
        totalHPTextField = new javax.swing.JTextField();
        deathsaveLabel = new javax.swing.JLabel();
        HPTextField = new javax.swing.JTextField();
        levelLabel = new javax.swing.JLabel();
        levelTextField = new javax.swing.JTextField();
        profTextField = new javax.swing.JTextField();
        acLabel = new javax.swing.JLabel();
        acTextField = new javax.swing.JTextField();
        attributePanel = new javax.swing.JPanel();
        bodLabel = new javax.swing.JLabel();
        bodStatTextField = new javax.swing.JTextField();
        bodModTextField = new javax.swing.JTextField();
        dexLabel = new javax.swing.JLabel();
        dexStatTextField = new javax.swing.JTextField();
        dexModTextField = new javax.swing.JTextField();
        mndLabel = new javax.swing.JLabel();
        mndStatTextField = new javax.swing.JTextField();
        mndModTextField = new javax.swing.JTextField();
        magLabel = new javax.swing.JLabel();
        magStatTextField = new javax.swing.JTextField();
        magModTextField = new javax.swing.JTextField();
        aspLabel = new javax.swing.JLabel();
        aspStatTextField = new javax.swing.JTextField();
        aspModTextField = new javax.swing.JTextField();
        attributesLabel = new javax.swing.JLabel();
        proficiencyCheckbox = new javax.swing.JCheckBox();
        characterComboBox = new javax.swing.JComboBox<>();
        newButton = new javax.swing.JButton();
        profLabel = new javax.swing.JLabel();
        claspectLabel = new javax.swing.JLabel();
        claspectTextField = new javax.swing.JTextField();
        titleLabel = new javax.swing.JLabel();
        titleTextField = new javax.swing.JTextField();
        hpDividerLabel = new javax.swing.JLabel();
        levelPanel = new javax.swing.JPanel();
        powerLabel = new javax.swing.JLabel();
        powerSpinner = new javax.swing.JSpinner();
        knowledgeLabel = new javax.swing.JLabel();
        knowledgeSpinner = new javax.swing.JSpinner();
        aspectLabel = new javax.swing.JLabel();
        aspectSpinner = new javax.swing.JSpinner();
        safetyLabel = new javax.swing.JLabel();
        safetySpinner = new javax.swing.JSpinner();
        levelsLabel = new javax.swing.JLabel();
        loadButton = new javax.swing.JButton();
        gristCachePanel = new javax.swing.JPanel();
        gristCacheLabel = new javax.swing.JLabel();
        gristCacheComboBox = new javax.swing.JComboBox<>();
        gristCacheSpinner = new javax.swing.JSpinner();
        newGristButton = new javax.swing.JButton();
        armourPanel = new javax.swing.JPanel();
        armourLabel = new javax.swing.JLabel();
        armourListPanel = new javax.swing.JPanel();
        attacksPanel = new javax.swing.JPanel();
        attacksLabel = new javax.swing.JLabel();
        attacksListPanel = new javax.swing.JPanel();
        proficiencyPanel = new javax.swing.JPanel();
        weaponProficiencyLabel = new javax.swing.JLabel();
        weaponKindLabel = new javax.swing.JLabel();
        weaponProficiencyTextField = new javax.swing.JTextField();
        skillProficiencyLabel = new javax.swing.JLabel();
        skillProficienciesPanel = new javax.swing.JPanel();
        skillProfButton = new javax.swing.JButton();
        techniquePanel = new javax.swing.JPanel();
        techniqueLabel = new javax.swing.JLabel();
        techniqueListPanel = new javax.swing.JPanel();
        resourcePanel = new javax.swing.JPanel();
        resourcesLabel = new javax.swing.JLabel();
        resourcesListPanel = new javax.swing.JPanel();
        lootRollerScrollPane = new javax.swing.JScrollPane();
        lootRollerPanel = new javax.swing.JPanel();
        monsterLootTableScrollPane = new javax.swing.JScrollPane();
        monsterLootTable = new javax.swing.JTable();
        monsterLootButton = new javax.swing.JButton();
        seperator1 = new javax.swing.JSeparator();
        diceRollerLabel = new javax.swing.JLabel();
        diceRollerTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Homestuck Character Sheet");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        outputCheckbox.setText("Output To Discord");

        advLabel.setText("Adv:");

        outputScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        outputTextArea.setColumns(20);
        outputTextArea.setLineWrap(true);
        outputTextArea.setRows(5);
        outputTextArea.setWrapStyleWord(true);
        outputScrollPane.setViewportView(outputTextArea);

        mainTabPane.setName(""); // NOI18N

        characterScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        characterPanel.setMinimumSize(new java.awt.Dimension(0, 1000));
        characterPanel.setPreferredSize(new java.awt.Dimension(560, 1000));
        characterPanel.setLayout(null);

        hpLabel.setText("HP: ");
        hpLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hpLabelMouseClicked(evt);
            }
        });
        characterPanel.add(hpLabel);
        hpLabel.setBounds(20, 100, 33, 30);

        totalHPTextField.setEditable(false);
        totalHPTextField.setText("auto");
        characterPanel.add(totalHPTextField);
        totalHPTextField.setBounds(105, 100, 30, 30);

        deathsaveLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deathsaveLabel.setText("Death Save");
        deathsaveLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        characterPanel.add(deathsaveLabel);
        deathsaveLabel.setBounds(460, 145, 80, 30);
        characterPanel.add(HPTextField);
        HPTextField.setBounds(60, 100, 30, 30);

        levelLabel.setText("Level:");
        characterPanel.add(levelLabel);
        levelLabel.setBounds(445, 60, 34, 30);

        levelTextField.setEditable(false);
        levelTextField.setText("auto");
        characterPanel.add(levelTextField);
        levelTextField.setBounds(495, 60, 45, 30);

        profTextField.setEditable(false);
        profTextField.setText("auto");
        characterPanel.add(profTextField);
        profTextField.setBounds(305, 145, 45, 30);

        acLabel.setText("AC:");
        characterPanel.add(acLabel);
        acLabel.setBounds(370, 145, 21, 30);

        acTextField.setEditable(false);
        acTextField.setText("auto");
        characterPanel.add(acTextField);
        acTextField.setBounds(400, 145, 45, 30);

        attributePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        attributePanel.setLayout(null);

        bodLabel.setText("BOD: ");
        attributePanel.add(bodLabel);
        bodLabel.setBounds(20, 40, 33, 30);
        attributePanel.add(bodStatTextField);
        bodStatTextField.setBounds(60, 40, 45, 30);

        bodModTextField.setEditable(false);
        bodModTextField.setText("auto");
        attributePanel.add(bodModTextField);
        bodModTextField.setBounds(115, 40, 45, 30);

        dexLabel.setText("DEX:");
        attributePanel.add(dexLabel);
        dexLabel.setBounds(20, 80, 28, 30);
        attributePanel.add(dexStatTextField);
        dexStatTextField.setBounds(60, 80, 45, 30);

        dexModTextField.setEditable(false);
        dexModTextField.setText("auto");
        attributePanel.add(dexModTextField);
        dexModTextField.setBounds(115, 80, 45, 30);

        mndLabel.setText("MND:");
        attributePanel.add(mndLabel);
        mndLabel.setBounds(20, 120, 31, 30);
        attributePanel.add(mndStatTextField);
        mndStatTextField.setBounds(60, 120, 45, 30);

        mndModTextField.setEditable(false);
        mndModTextField.setText("auto");
        attributePanel.add(mndModTextField);
        mndModTextField.setBounds(115, 120, 45, 30);

        magLabel.setText("MAG:");
        attributePanel.add(magLabel);
        magLabel.setBounds(20, 160, 31, 30);
        attributePanel.add(magStatTextField);
        magStatTextField.setBounds(60, 160, 45, 30);

        magModTextField.setEditable(false);
        magModTextField.setText("auto");
        attributePanel.add(magModTextField);
        magModTextField.setBounds(115, 160, 45, 30);

        aspLabel.setText("ASP:");
        attributePanel.add(aspLabel);
        aspLabel.setBounds(20, 200, 28, 30);
        attributePanel.add(aspStatTextField);
        aspStatTextField.setBounds(60, 200, 45, 30);

        aspModTextField.setEditable(false);
        aspModTextField.setText("auto");
        attributePanel.add(aspModTextField);
        aspModTextField.setBounds(115, 200, 45, 30);

        attributesLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        attributesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        attributesLabel.setText("Attributes");
        attributePanel.add(attributesLabel);
        attributesLabel.setBounds(10, 10, 160, 16);

        proficiencyCheckbox.setText("Proficiency");
        attributePanel.add(proficiencyCheckbox);
        proficiencyCheckbox.setBounds(20, 240, 140, 25);

        characterPanel.add(attributePanel);
        attributePanel.setBounds(20, 140, 180, 280);

        characterPanel.add(characterComboBox);
        characterComboBox.setBounds(20, 20, 385, 30);

        newButton.setText("New");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });
        characterPanel.add(newButton);
        newButton.setBounds(485, 20, 57, 30);

        profLabel.setText("PROF Bonus:");
        characterPanel.add(profLabel);
        profLabel.setBounds(220, 145, 80, 30);

        claspectLabel.setText("Claspect: ");
        characterPanel.add(claspectLabel);
        claspectLabel.setBounds(20, 60, 60, 30);
        characterPanel.add(claspectTextField);
        claspectTextField.setBounds(90, 60, 110, 30);

        titleLabel.setText("Title:");
        characterPanel.add(titleLabel);
        titleLabel.setBounds(220, 60, 40, 30);
        characterPanel.add(titleTextField);
        titleTextField.setBounds(270, 60, 155, 30);

        hpDividerLabel.setText("/");
        characterPanel.add(hpDividerLabel);
        hpDividerLabel.setBounds(95, 100, 5, 30);

        levelPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        levelPanel.setLayout(null);

        powerLabel.setText("Power:");
        levelPanel.add(powerLabel);
        powerLabel.setBounds(20, 40, 41, 30);

        powerSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        levelPanel.add(powerSpinner);
        powerSpinner.setBounds(100, 40, 45, 30);

        knowledgeLabel.setText("Knowledge:");
        levelPanel.add(knowledgeLabel);
        knowledgeLabel.setBounds(175, 40, 67, 30);

        knowledgeSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        levelPanel.add(knowledgeSpinner);
        knowledgeSpinner.setBounds(255, 40, 45, 30);

        aspectLabel.setText("Aspect:");
        levelPanel.add(aspectLabel);
        aspectLabel.setBounds(175, 80, 43, 30);

        aspectSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        levelPanel.add(aspectSpinner);
        aspectSpinner.setBounds(255, 80, 45, 30);

        safetyLabel.setText("Safety:");
        levelPanel.add(safetyLabel);
        safetyLabel.setBounds(20, 80, 41, 30);

        safetySpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        levelPanel.add(safetySpinner);
        safetySpinner.setBounds(100, 80, 45, 30);

        levelsLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        levelsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        levelsLabel.setText("Levels");
        levelPanel.add(levelsLabel);
        levelsLabel.setBounds(10, 10, 300, 16);

        characterPanel.add(levelPanel);
        levelPanel.setBounds(220, 195, 320, 130);

        loadButton.setText("Load");
        characterPanel.add(loadButton);
        loadButton.setBounds(415, 20, 59, 30);

        gristCachePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gristCachePanel.setLayout(null);

        gristCacheLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        gristCacheLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gristCacheLabel.setText("Grist Cache");
        gristCachePanel.add(gristCacheLabel);
        gristCacheLabel.setBounds(10, 10, 160, 16);

        gristCachePanel.add(gristCacheComboBox);
        gristCacheComboBox.setBounds(20, 40, 140, 30);

        gristCacheSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        gristCachePanel.add(gristCacheSpinner);
        gristCacheSpinner.setBounds(20, 115, 140, 30);

        newGristButton.setText("Add New Grist");
        newGristButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGristButtonActionPerformed(evt);
            }
        });
        gristCachePanel.add(newGristButton);
        newGristButton.setBounds(20, 80, 140, 25);

        characterPanel.add(gristCachePanel);
        gristCachePanel.setBounds(20, 440, 180, 165);

        armourPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        armourPanel.setLayout(null);

        armourLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        armourLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        armourLabel.setText("Armour");
        armourPanel.add(armourLabel);
        armourLabel.setBounds(10, 10, 300, 16);

        javax.swing.GroupLayout armourListPanelLayout = new javax.swing.GroupLayout(armourListPanel);
        armourListPanel.setLayout(armourListPanelLayout);
        armourListPanelLayout.setHorizontalGroup(
            armourListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        armourListPanelLayout.setVerticalGroup(
            armourListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        armourPanel.add(armourListPanel);
        armourListPanel.setBounds(20, 30, 280, 0);

        characterPanel.add(armourPanel);
        armourPanel.setBounds(220, 345, 320, 50);

        attacksPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        attacksPanel.setLayout(null);

        attacksLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        attacksLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        attacksLabel.setText("Attacks");
        attacksPanel.add(attacksLabel);
        attacksLabel.setBounds(10, 10, 300, 16);

        javax.swing.GroupLayout attacksListPanelLayout = new javax.swing.GroupLayout(attacksListPanel);
        attacksListPanel.setLayout(attacksListPanelLayout);
        attacksListPanelLayout.setHorizontalGroup(
            attacksListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        attacksListPanelLayout.setVerticalGroup(
            attacksListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        attacksPanel.add(attacksListPanel);
        attacksListPanel.setBounds(20, 30, 280, 0);

        characterPanel.add(attacksPanel);
        attacksPanel.setBounds(220, 415, 320, 50);

        proficiencyPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        proficiencyPanel.setLayout(null);

        weaponProficiencyLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        weaponProficiencyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        weaponProficiencyLabel.setText("Weapon Proficiency");
        proficiencyPanel.add(weaponProficiencyLabel);
        weaponProficiencyLabel.setBounds(10, 10, 160, 16);

        weaponKindLabel.setText("-kind");
        proficiencyPanel.add(weaponKindLabel);
        weaponKindLabel.setBounds(131, 40, 30, 30);

        weaponProficiencyTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        proficiencyPanel.add(weaponProficiencyTextField);
        weaponProficiencyTextField.setBounds(20, 40, 110, 30);

        skillProficiencyLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        skillProficiencyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        skillProficiencyLabel.setText("Skill Proficiencies");
        proficiencyPanel.add(skillProficiencyLabel);
        skillProficiencyLabel.setBounds(10, 90, 160, 16);

        skillProficienciesPanel.setLayout(null);
        proficiencyPanel.add(skillProficienciesPanel);
        skillProficienciesPanel.setBounds(20, 120, 140, 0);

        skillProfButton.setText("Add New Prof");
        skillProfButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skillProfButtonActionPerformed(evt);
            }
        });
        proficiencyPanel.add(skillProfButton);
        skillProfButton.setBounds(20, 140, 140, 25);

        characterPanel.add(proficiencyPanel);
        proficiencyPanel.setBounds(20, 625, 180, 180);

        techniquePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        techniquePanel.setLayout(null);

        techniqueLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        techniqueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        techniqueLabel.setText("Techniques");
        techniquePanel.add(techniqueLabel);
        techniqueLabel.setBounds(10, 10, 300, 16);

        javax.swing.GroupLayout techniqueListPanelLayout = new javax.swing.GroupLayout(techniqueListPanel);
        techniqueListPanel.setLayout(techniqueListPanelLayout);
        techniqueListPanelLayout.setHorizontalGroup(
            techniqueListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        techniqueListPanelLayout.setVerticalGroup(
            techniqueListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        techniquePanel.add(techniqueListPanel);
        techniqueListPanel.setBounds(20, 30, 280, 0);

        characterPanel.add(techniquePanel);
        techniquePanel.setBounds(220, 555, 320, 50);

        resourcePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        resourcePanel.setLayout(null);

        resourcesLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        resourcesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resourcesLabel.setText("Resources");
        resourcePanel.add(resourcesLabel);
        resourcesLabel.setBounds(10, 10, 300, 16);

        javax.swing.GroupLayout resourcesListPanelLayout = new javax.swing.GroupLayout(resourcesListPanel);
        resourcesListPanel.setLayout(resourcesListPanelLayout);
        resourcesListPanelLayout.setHorizontalGroup(
            resourcesListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        resourcesListPanelLayout.setVerticalGroup(
            resourcesListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        resourcePanel.add(resourcesListPanel);
        resourcesListPanel.setBounds(20, 30, 280, 0);

        characterPanel.add(resourcePanel);
        resourcePanel.setBounds(220, 485, 320, 50);

        characterScrollPane.setViewportView(characterPanel);

        mainTabPane.addTab("Character Sheet", characterScrollPane);

        lootRollerScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        lootRollerPanel.setMinimumSize(new java.awt.Dimension(0, 1000));
        lootRollerPanel.setPreferredSize(new java.awt.Dimension(560, 1000));
        lootRollerPanel.setLayout(null);

        monsterLootTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Loot", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        monsterLootTable.setRowHeight(30);
        monsterLootTableScrollPane.setViewportView(monsterLootTable);

        lootRollerPanel.add(monsterLootTableScrollPane);
        monsterLootTableScrollPane.setBounds(10, 10, 540, 270);

        monsterLootButton.setText("Roll Loot");
        monsterLootButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monsterLootButtonActionPerformed(evt);
            }
        });
        lootRollerPanel.add(monsterLootButton);
        monsterLootButton.setBounds(429, 290, 120, 25);

        lootRollerScrollPane.setViewportView(lootRollerPanel);

        mainTabPane.addTab("Loot Roller", lootRollerScrollPane);

        diceRollerLabel.setText("Dice Roller: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outputScrollPane)
                    .addComponent(mainTabPane)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(diceRollerLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(diceRollerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(outputCheckbox)
                        .addGap(42, 42, 42)
                        .addComponent(advLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(advSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addContainerGap())
            .addComponent(seperator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(mainTabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seperator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(diceRollerLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(outputCheckbox)
                        .addComponent(advLabel)
                        .addComponent(advSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(diceRollerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addComponent(outputScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        File tmpDir = new File("data/startup.xml");
        advantage = advSpinner;
        prof = profTextField;
        discord = outputCheckbox;
        area = outputTextArea;
        window = this;

        characters = new HashMap();
        String selectedCharacter;
        if (!tmpDir.exists()) {
            String s = (String) JOptionPane.showInputDialog(this, "Enter first character name:", "Input required", JOptionPane.PLAIN_MESSAGE, null, null, "");
            try {
                File dir = new File("data");
                dir.mkdir();
                File dirChar = new File("data/characters");
                dirChar.mkdir();
                FileWriter fw = new FileWriter("data/startup.xml");
                fw.write("<main>\n");
                fw.append("    <default>" + s + "</default>\n");
                fw.append("    <character>" + s.toLowerCase() + ".xml</character>\n");
                fw.append("</main>");
                fw.flush();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            }
            Character c = new Character(s, 10, 10, 10, 10, 10, 0, 0, 0, 0, "", "", 10, "");
            c.addGrist("Build Grist", 0);
            c.addGrist("Abstraction Grist", 0);
            c.addItem(Character.DEFAULT_WEAPON);
            characterComboBox.addItem(s);
            characters.put(s, c);
            selectedCharacter = s;
            saveCharacter(c);
        } else {
            XMLElement startup = XMLReader.readXMLFile("data/startup.xml");
            for (XMLElement charElement : startup.children.get("character")) {

                XMLElement character = XMLReader.readXMLFile("data/characters/" + charElement.textContent);

                characterComboBox.addItem(character.children.get("name").get(0).textContent);

                Character c = new Character(character.children.get("name").get(0).textContent,
                        Integer.parseInt(character.children.get("bod").get(0).textContent),
                        Integer.parseInt(character.children.get("dex").get(0).textContent),
                        Integer.parseInt(character.children.get("mnd").get(0).textContent),
                        Integer.parseInt(character.children.get("mag").get(0).textContent),
                        Integer.parseInt(character.children.get("asp").get(0).textContent),
                        Integer.parseInt(character.children.get("power").get(0).textContent),
                        Integer.parseInt(character.children.get("safety").get(0).textContent),
                        Integer.parseInt(character.children.get("knowledge").get(0).textContent),
                        Integer.parseInt(character.children.get("aspect").get(0).textContent),
                        character.children.get("claspect").get(0).textContent,
                        character.children.get("title").get(0).textContent,
                        Integer.parseInt(character.children.get("currentHp").get(0).textContent),
                        character.children.get("weaponProf").get(0).textContent);

                for (XMLElement grist : character.children.get("grist")) {
                    c.addGrist(grist.children.get("type").get(0).textContent,
                            Integer.parseInt(grist.children.get("quantity").get(0).textContent));
                }

                if (character.children.containsKey("armour")) {
                    for (XMLElement armour : character.children.get("armour")) {
                        Armour armourItem = new Armour(armour.children.get("name").get(0).textContent,
                                Integer.parseInt(armour.children.get("acBonus").get(0).textContent),
                                Integer.parseInt(armour.children.get("maxDexMod").get(0).textContent));
                        c.addItem(armourItem);
                        if (character.children.get("equiped").get(0).textContent.equals(armourItem.name)) {
                            c.equiped = armourItem;
                        }
                    }
                }

                if (character.children.containsKey("skillProf")) {
                    for (XMLElement skill : character.children.get("skillProf")) {
                        c.skillProficiencies.add(skill.textContent);
                    }
                }

                if (character.children.containsKey("onRoll")) {
                    for (XMLElement onRoll : character.children.get("onRoll")) {

                        try {
                            Class onRollClass = Class.forName("musketstuckcharactersheet.onRollFunctions." + onRoll.textContent);
                            Class[] types = {};
                            Constructor constructor = onRollClass.getConstructor(types);
                            Object[] parameters = {};
                            OnRoll onRollInstance = (OnRoll) constructor.newInstance(parameters);

                            c.addOnRoll(onRoll.textContent, onRollInstance);
                        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }

                if (character.children.containsKey("weapon")) {
                    for (XMLElement weapon : character.children.get("weapon")) {
                        ArrayList<Attack> attackList = new ArrayList();

                        if (weapon.children.containsKey("attack")) {
                            for (XMLElement attack : weapon.children.get("attack")) {
                                Attack attackItem;
                                if (attack.children.containsKey("hitBonus")) {
                                    attackItem = new Attack(attack.children.get("name").get(0).textContent,
                                            Integer.parseInt(attack.children.get("hitBonus").get(0).textContent),
                                            attack.children.get("damage").get(0).textContent,
                                            Integer.parseInt(attack.children.get("crit").get(0).textContent),
                                            Integer.parseInt(attack.children.get("critMul").get(0).textContent),
                                            attack.children.get("ability").get(0).textContent);
                                    if (attack.children.containsKey("bonus")) {
                                        for (XMLElement bonus : attack.children.get("bonus")) {
                                            if (bonus.textContent.equals("damageAdvantage")) {
                                                attackItem.setDamageAdvantage(true);
                                            }
                                        }
                                    }
                                } else {
                                    attackItem = new Attack(attack.children.get("name").get(0).textContent,
                                            attack.children.get("damage").get(0).textContent);
                                }
                                attackItem.addOnRoll(c.getOnRollFunctions());
                                attackList.add(attackItem);
                            }
                        }

                        Weapon weaponItem = new Weapon(weapon.children.get("name").get(0).textContent,
                                weapon.children.get("type").get(0).textContent, attackList);
                        c.addItem(weaponItem);
                    }
                }

                if (character.children.containsKey("technique")) {
                    for (XMLElement technique : character.children.get("technique")) {
                        c.techniques.add(new String[]{technique.children.get("name").get(0).textContent,
                            technique.children.get("source").get(0).textContent,
                            technique.children.get("description").get(0).textContent});
                    }
                }

                if (character.children.containsKey("resource")) {
                    for (XMLElement resource : character.children.get("resource")) {
                        c.resources.put(resource.children.get("name").get(0).textContent,
                                Integer.parseInt(resource.children.get("value").get(0).textContent));
                    }
                }

                characters.put(c.name, c);
            }

            monsters = new HashMap();

            if (startup.children.containsKey("monster")) {
                for (XMLElement monElement : startup.children.get("monster")) {

                    XMLElement monster = XMLReader.readXMLFile("data/monsters/" + monElement.textContent);

                    Monster m = new Monster(monster.children.get("name").get(0).textContent);

                    for (XMLElement grist : monster.children.get("grist")) {
                        m.addLoot(grist.children.get("type").get(0).textContent, grist.children.get("quantity").get(0).textContent);
                    }

                    monsters.put(monster.children.get("name").get(0).textContent, m);

                }
            }

            selectedCharacter = startup.children.get("default").get(0).textContent;

        }
        characterComboBox.setSelectedItem(selectedCharacter);
        loadCharacter(characters.get(selectedCharacter));
        currentSelection = selectedCharacter;
        currentGrist = 0;

        characterComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                save(characters.get(currentSelection));
                loadCharacter(characters.get(characterComboBox.getSelectedItem()));
                currentSelection = (String) characterComboBox.getSelectedItem();
            }
        });
        gristCacheComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (gristCacheComboBox.getSelectedIndex() >= 0) {
                    save(characters.get(currentSelection));
                    currentGrist = gristCacheComboBox.getSelectedIndex();
                    gristCacheSpinner.setValue(characters.get(currentSelection).gristCache.get(currentGrist).getValue());
                }
            }
        });

        healthBar = new JCanvas(155, 105, 385, 20, this);
        characterPanel.add(healthBar);

        modRef = new HashMap();
        modRef.put("BOD", bodModTextField);
        modRef.put("DEX", dexModTextField);
        modRef.put("MND", mndModTextField);
        modRef.put("MAG", magModTextField);
        modRef.put("ASP", aspModTextField);
        statRef = new HashMap();
        statRef.put("BOD", bodStatTextField);
        statRef.put("DEX", dexStatTextField);
        statRef.put("MND", mndStatTextField);
        statRef.put("MAG", magStatTextField);
        statRef.put("ASP", aspStatTextField);

        DocumentListener changeUpdater = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                refresh();
            }

            public void removeUpdate(DocumentEvent e) {
                refresh();
            }

            public void changedUpdate(DocumentEvent e) {
                refresh();
            }
        };

        for (String string : statRef.keySet()) {
            statRef.get(string).getDocument().addDocumentListener(changeUpdater);
        }

        HPTextField.getDocument().addDocumentListener(changeUpdater);
        powerSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                refresh();
            }
        });
        safetySpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                refresh();
            }
        });
        knowledgeSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                refresh();
            }
        });
        aspectSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                refresh();
            }
        });

        refresh();

        labelRef = new HashMap();
        labelRef.put("BOD", bodLabel);
        labelRef.put("DEX", dexLabel);
        labelRef.put("MND", mndLabel);
        labelRef.put("MAG", magLabel);
        labelRef.put("ASP", aspLabel);
        for (String string : labelRef.keySet()) {
            labelRef.get(string).addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Pair<String, Integer> hitRolls = DiceParser.parse("(1d20)a" + Math.abs((int) advSpinner.getValue())).roll(characters.get(currentSelection).getOnRollFunctions(), OnRoll.Trigger.ABILITY);
                    if ((int) advSpinner.getValue() < 0) {
                        hitRolls = DiceParser.parse("(1d20)z" + Math.abs((int) advSpinner.getValue())).roll(characters.get(currentSelection).getOnRollFunctions(), OnRoll.Trigger.ABILITY);
                    }
                    int result = hitRolls.getValue() + Integer.parseInt(modRef.get(string).getText());
                    if (proficiencyCheckbox.isSelected()) {
                        result += Integer.parseInt(profTextField.getText());
                    }
                    String output = hitRolls.getKey() + "+" + modRef.get(string).getText();
                    if (proficiencyCheckbox.isSelected()) {
                        output += "+" + Integer.parseInt(profTextField.getText());
                    }
                    output += "=" + result;

                    Output.outputText(string + " Roll", output, window);
                }

                public void mousePressed(MouseEvent e) {

                }

                public void mouseReleased(MouseEvent e) {

                }

                public void mouseEntered(MouseEvent e) {

                }

                public void mouseExited(MouseEvent e) {

                }
            });

        }
        deathsaveLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rollDeathSave();
            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        });

        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
        monsterLootTable.getColumn("Loot").setCellRenderer(buttonRenderer);
        DefaultTableModel model = (DefaultTableModel) monsterLootTable.getModel();
        for (Monster monster : monsters.values()) {
            JButton displayLoot = new JButton("Show Loot");
            model.addRow(new Object[]{monster.name, displayLoot, 0});
        }
        monsterLootTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = monsterLootTable.rowAtPoint(evt.getPoint());
                int col = monsterLootTable.columnAtPoint(evt.getPoint());
                if (col == 1) {
                    String monsterName = (String) monsterLootTable.getValueAt(row, 0);
                    String lootString = monsterName + " Loot:";
                    for (Entry<String, String> grist : monsters.get(monsterName).loot.entrySet()) {
                        lootString += "\n" + grist.getKey() + ": " + grist.getValue();
                    }
                    JOptionPane.showMessageDialog(null, lootString, "Monster Loot", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        diceRollerTextField.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {

            }

            public void keyPressed(KeyEvent e) {

            }

            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        String input = diceRollerTextField.getText();
                        for (Entry<String, JTextField> entry : modRef.entrySet()) {
                            input = input.replace(entry.getKey(), entry.getValue().getText());
                        }
                        input = input.replace("PROF", profTextField.getText());

                        Pair<String, Integer> output = DiceParser.parse(input).roll(characters.get(currentSelection).getOnRollFunctions(), OnRoll.Trigger.ROLL);

                        Output.outputText("Dice Roll", output.getKey() + "=" + output.getValue(), window);
                        diceRollerTextField.setText("");
                    } catch (Exception x) {
                        Output.outputText("Dice Roll", "Parsing Error Occured", window);
                    }
                }
            }
        });

    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        save(characters.get(currentSelection));
        try {
            FileWriter fw = new FileWriter("data/startup.xml");
            fw.write("<main>\n");
            fw.append("    <default>" + currentSelection + "</default>\n");
            for (Character value : characters.values()) {
                fw.append("    <character>" + value.name.toLowerCase() + ".xml</character>\n");
            }
            for (Monster value : monsters.values()) {
                fw.append("    <monster>" + value.name.toLowerCase() + ".xml</monster>\n");
            }
            fw.append("</main>");
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        String s = (String) JOptionPane.showInputDialog(this, "Enter character name:", "Input required", JOptionPane.PLAIN_MESSAGE, null, null, "");
        boolean found = false;
        for (String string : characters.keySet()) {
            if (string.toLowerCase().equals(s.toLowerCase())) {
                found = true;
            }
        }
        if (found) {
            JOptionPane.showMessageDialog(this, "This name already exists.", "Input required", JOptionPane.ERROR_MESSAGE);
        } else {
            Character c = new Character(s, 10, 10, 10, 10, 10, 0, 0, 0, 0, "", "", 10, "");
            c.addGrist("Build Grist", 0);
            c.addGrist("Abstraction Grist", 0);
            c.addItem(Character.DEFAULT_WEAPON);
            characterComboBox.addItem(s);
            characters.put(s, c);
        }
    }//GEN-LAST:event_newButtonActionPerformed

    private void newGristButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGristButtonActionPerformed
        String s = (String) JOptionPane.showInputDialog(this, "Enter new grist name:", "Input required", JOptionPane.PLAIN_MESSAGE, null, null, "");
        boolean found = false;
        for (String string : characters.keySet()) {
            if (string.toLowerCase().equals(s.toLowerCase())) {
                found = true;
            }
        }
        if (found) {
            JOptionPane.showMessageDialog(this, "This grist already exists.", "Input required", JOptionPane.ERROR_MESSAGE);
        } else {
            characters.get(currentSelection).addGrist(s, 0);
            gristCacheComboBox.addItem(s);
            gristCacheComboBox.setSelectedItem(s);
            save(characters.get(currentSelection));
            currentGrist = characters.get(currentSelection).gristCache.size() - 1;
            gristCacheSpinner.setValue(characters.get(currentSelection).gristCache.get(currentGrist).getValue());
        }
    }//GEN-LAST:event_newGristButtonActionPerformed

    private void hpLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hpLabelMouseClicked
        int s = Integer.parseInt((String) JOptionPane.showInputDialog(this, "Enter a health mod:", "Input required", JOptionPane.PLAIN_MESSAGE, null, null, ""));

        HPTextField.setText((Integer.parseInt(HPTextField.getText()) + s) + "");

        if (Integer.parseInt(HPTextField.getText()) < 0) {
            if (rollDeathSave(s)) {
                if (s < 0) {
                    HPTextField.setText((Integer.parseInt(HPTextField.getText()) - s) + "");
                }
            }
        }

    }//GEN-LAST:event_hpLabelMouseClicked

    private void monsterLootButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monsterLootButtonActionPerformed
        HashMap<String, Integer> totalLoot = new HashMap();
        for (int i = 0; i < monsterLootTable.getRowCount(); i++) {
            for (Entry<String, String> grist : monsters.get(monsterLootTable.getValueAt(i, 0)).loot.entrySet()) {
                int loot = (int) DiceParser.parse("(" + grist.getValue() + ")r" + monsterLootTable.getValueAt(i, 2)).roll(characters.get(currentSelection).getOnRollFunctions(), OnRoll.Trigger.LOOT).getValue();
                if (totalLoot.containsKey(grist.getKey())) {
                    loot += totalLoot.get(grist.getKey());
                    totalLoot.remove(grist.getKey());
                    totalLoot.put(grist.getKey(), loot);
                } else if (loot > 0) {
                    totalLoot.put(grist.getKey(), loot);
                }
            }
        }
        int count = 0;
        for (Entry<String, Integer> entry : totalLoot.entrySet()) {
            if (entry.getValue() > 0) {
                count++;
            }
        }
        String[] titles = new String[count];
        String[] messages = new String[count];
        int i = 0;
        for (Entry<String, Integer> entry : totalLoot.entrySet()) {
            if (entry.getValue() > 0) {
                titles[i] = entry.getKey();
                messages[i] = entry.getValue() + "";
                i++;
            }
        }
        Output.outputText(titles, messages, window);
        int n = JOptionPane.showConfirmDialog(this, "Would you like to add this grist to the current cache?", "Input required", JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            mainTabPane.setSelectedIndex(0);
            for (Entry<String, Integer> entry : totalLoot.entrySet()) {
                boolean found = false;
                for (int j = 0; j < characters.get(currentSelection).gristCache.size(); j++) {
                    Pair<String, Integer> pair = characters.get(currentSelection).gristCache.get(j);
                    if (pair.getKey().equals(entry.getKey())) {
                        found = true;
                        characters.get(currentSelection).gristCache.remove(j);
                        characters.get(currentSelection).gristCache.add(j, new Pair(pair.getKey(), pair.getValue() + entry.getValue()));
                    }
                }
                if (!found) {
                    characters.get(entry.getKey()).gristCache.add(new Pair(entry.getKey(), entry.getValue()));
                }
            }
            gristCacheSpinner.setValue(characters.get(currentSelection).gristCache.get(currentGrist).getValue());
        }

    }//GEN-LAST:event_monsterLootButtonActionPerformed

    private void skillProfButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skillProfButtonActionPerformed
        String s = (String) JOptionPane.showInputDialog(this, "Enter new skill proficiency name:", "Input required", JOptionPane.PLAIN_MESSAGE, null, null, "");

        characters.get(currentSelection).skillProficiencies.add(s);
        save(characters.get(currentSelection));
        loadCharacter(characters.get(currentSelection));
    }//GEN-LAST:event_skillProfButtonActionPerformed

    public void rollDeathSave() {
        rollDeathSave(0);
    }

    public boolean rollDeathSave(int s) {
        Pair<String, Integer> hitRolls = DiceParser.parse("(1d20)a" + Math.abs((int) advSpinner.getValue())).roll(characters.get(currentSelection).getOnRollFunctions(), OnRoll.Trigger.SAVE);
        if ((int) advSpinner.getValue() < 0) {
            hitRolls = DiceParser.parse("(1d20)z" + Math.abs((int) advSpinner.getValue())).roll(characters.get(currentSelection).getOnRollFunctions(), OnRoll.Trigger.SAVE);
        }
        int result = hitRolls.getValue() + Integer.parseInt(modRef.get("BOD").getText());
        if (proficiencyCheckbox.isSelected()) {
            result += Integer.parseInt(profTextField.getText());
        }
        String output = hitRolls.getKey() + "+" + modRef.get("BOD").getText();
        if (proficiencyCheckbox.isSelected()) {
            output += "+" + Integer.parseInt(profTextField.getText());
        }
        output += "=" + result;

        String rollResult = "FAILIURE";
        boolean crit = false;
        if (hitRolls.getValue() == 20) {
            rollResult = "CRITICAL SUCCESS, DAMAGE AVOIDED";
            crit = true;
        } else {
            if (result >= Integer.parseInt(HPTextField.getText()) * -1) {
                rollResult = "SUCCESS";
            }
        }

        Output.outputText("Death Save", output + " " + rollResult, window);
        return crit;
    }

    public void refresh() {
        try {
            bodModTextField.setText(((Integer.parseInt(bodStatTextField.getText()) - 10) / 2) + "");
        } catch (Exception x) {
            bodModTextField.setText("");
        }
        try {
            dexModTextField.setText(Math.min(characters.get(currentSelection).equiped.maxDexMod, (Integer.parseInt(dexStatTextField.getText()) - 10) / 2) + "");
        } catch (Exception x) {
            dexModTextField.setText("");
        }
        try {
            mndModTextField.setText(((Integer.parseInt(mndStatTextField.getText()) - 10) / 2) + "");
        } catch (Exception x) {
            mndModTextField.setText("");
        }
        try {
            magModTextField.setText(((Integer.parseInt(magStatTextField.getText()) - 10) / 2) + "");
        } catch (Exception x) {
            magModTextField.setText("");
        }
        try {
            aspModTextField.setText(((Integer.parseInt(aspStatTextField.getText()) - 10) / 2) + "");
        } catch (Exception x) {
            aspModTextField.setText("");
        }
        int totalLevel = (int) powerSpinner.getValue() + (int) safetySpinner.getValue() + (int) knowledgeSpinner.getValue() + (int) aspectSpinner.getValue();
        levelTextField.setText(totalLevel + "");
        try {
            profTextField.setText((((Integer.parseInt(levelTextField.getText()) - 1) / 4) + 2) + "");
        } catch (Exception x) {
            profTextField.setText("");
        }
        try {
            acTextField.setText((characters.get(currentSelection).equiped.acBonus + 10 + Integer.parseInt(modRef.get("DEX").getText())) + "");
        } catch (Exception x) {
            acTextField.setText("");
        }
        try {
            totalHPTextField.setText(((int) powerSpinner.getValue() * (5 + Integer.parseInt(modRef.get("BOD").getText()))
                    + (int) safetySpinner.getValue() * (7 + Integer.parseInt(modRef.get("BOD").getText()))
                    + (int) knowledgeSpinner.getValue() * (4 + Integer.parseInt(modRef.get("BOD").getText()))
                    + (int) aspectSpinner.getValue() * (5 + Integer.parseInt(modRef.get("BOD").getText()))
                    + 10 + Integer.parseInt(modRef.get("BOD").getText())) + "");
        } catch (Exception x) {
            totalHPTextField.setText("");
        }

        try {
            healthBar.repaint();
        } catch (NullPointerException e) {

        }

    }

    public void loadCharacter(Character c) {
        bodStatTextField.setText(c.bod + "");
        dexStatTextField.setText(c.dex + "");
        mndStatTextField.setText(c.mnd + "");
        magStatTextField.setText(c.mag + "");
        aspStatTextField.setText(c.asp + "");

        powerSpinner.setValue(c.power);
        safetySpinner.setValue(c.safety);
        knowledgeSpinner.setValue(c.knowledge);
        aspectSpinner.setValue(c.aspect);

        claspectTextField.setText(c.claspect);
        titleTextField.setText(c.title);

        HPTextField.setText(c.currentHp + "");
        weaponProficiencyTextField.setText(c.weaponProf + "");

        gristCacheComboBox.removeAllItems();
        ArrayList<String> names = new ArrayList();
        for (Pair<String, Integer> p : c.gristCache) {
            names.add(p.getKey());
        }
        for (String name : names) {
            gristCacheComboBox.addItem(name);
        }

        currentGrist = 0;
        gristCacheSpinner.setValue(c.gristCache.get(currentGrist).getValue());

        armourElements = new ArrayList();
        int size = c.armourpodes.size();
        armourPanel.setSize(320, 50 + size * 50);
        armourListPanel.setSize(280, size * 50);
        armourListPanel.removeAll();
        for (int i = 0; i < c.armourpodes.size(); i++) {
            boolean equiped = false;
            if (c.armourpodes.get(i).name.equals(c.equiped.name)) {
                equiped = true;
            }
            ArmourListElement element = new ArmourListElement(10 * (i + 1) + 40 * i, 280, equiped, armourElements, this, c.armourpodes.get(i));
            armourListPanel.add(element);
            armourElements.add(element);
        }

        attackElements = new ArrayList();
        attacksPanel.setLocation(220, armourPanel.getY() + armourPanel.getHeight() + 20);
        int yCount = 0;
        attacksListPanel.removeAll();
        for (int i = 0; i < c.weapons.size(); i++) {
            yCount += 10;
            WeaponListElement element = new WeaponListElement(yCount, 280, this, c.weapons.get(i));
            attacksListPanel.add(element);
            attackElements.add(element);
            yCount += element.getHeight();
        }
        attacksListPanel.setSize(280, yCount);
        attacksPanel.setSize(320, 50 + yCount);

        yCount = 0;
        skillProficienciesPanel.removeAll();
        for (String skillProficiency : c.skillProficiencies) {
            SkillProficiencyListElement skillLabel = new SkillProficiencyListElement(yCount, this, skillProficiency);
            skillLabel.addOnRoll(c.getOnRollFunctions());
            skillProficienciesPanel.add(skillLabel);
            yCount += 20;
        }
        skillProficienciesPanel.setSize(140, yCount);
        proficiencyPanel.setSize(180, 180 + yCount);
        skillProfButton.setLocation(20, 140 + yCount);

        resourceElements = new ArrayList();
        resourcePanel.setLocation(220, attacksPanel.getY() + attacksPanel.getHeight() + 20);
        yCount = 5;
        for (Entry<String, Integer> entry : c.resources.entrySet()) {
            ResourceListElement resourceElement = new ResourceListElement(yCount, 280, this, entry.getKey(), entry.getValue());
            resourceElements.add(resourceElement);
            resourcesListPanel.add(resourceElement);
            yCount += 25;
        }
        resourcesListPanel.setSize(280, yCount);
        resourcePanel.setSize(320, 50 + yCount);
        
        techniquePanel.setLocation(220, resourcePanel.getY() + resourcePanel.getHeight() + 20);
        yCount = 5;
        for (String[] technique : c.techniques) {
            TechniqueListElement techniqueLabel = new TechniqueListElement(yCount, 280, this, technique[0], technique[1], technique[2]);
            techniqueListPanel.add(techniqueLabel);
            yCount += 25;
        }
        techniqueListPanel.setSize(280, yCount);
        techniquePanel.setSize(320, 50 + yCount);

        Dimension d = new Dimension(560, Math.max(proficiencyPanel.getY() + proficiencyPanel.getHeight() + 20, techniquePanel.getY() + techniquePanel.getHeight() + 20));
        characterPanel.setPreferredSize(d);

        refresh();
    }

    public void save(Character c) {
        try {
            c.bod = Integer.parseInt(bodStatTextField.getText());
            c.dex = Integer.parseInt(dexStatTextField.getText());
            c.mnd = Integer.parseInt(mndStatTextField.getText());
            c.mag = Integer.parseInt(magStatTextField.getText());
            c.asp = Integer.parseInt(aspStatTextField.getText());

            c.power = (int) powerSpinner.getValue();
            c.safety = (int) safetySpinner.getValue();
            c.knowledge = (int) knowledgeSpinner.getValue();
            c.aspect = (int) aspectSpinner.getValue();

            c.claspect = claspectTextField.getText();
            c.title = titleTextField.getText();

            c.currentHp = Integer.parseInt(HPTextField.getText());
            c.weaponProf = weaponProficiencyTextField.getText();

            String gristName = c.gristCache.get(currentGrist).getKey();
            c.gristCache.remove(currentGrist);
            c.gristCache.add(currentGrist, new Pair(gristName, gristCacheSpinner.getValue()));
            
            for (ResourceListElement resourceElement : resourceElements) {
                for (Entry<String, Integer> entry : c.resources.entrySet()) {
                    if (entry.getKey().equals(resourceElement.name)) {
                        entry.setValue((int) resourceElement.counter.getValue());
                    }
                }
            }

            saveCharacter(c);
        } catch (Exception e) {

        }

    }

    public void saveCharacter(Character c) {
        try {
            FileWriter fw = new FileWriter("data/characters/" + c.name.toLowerCase() + ".xml");
            fw.write("<character>\n");
            fw.append("    <name>" + c.name + "</name>\n");
            fw.append("    <bod>" + c.bod + "</bod>\n");
            fw.append("    <dex>" + c.dex + "</dex>\n");
            fw.append("    <mnd>" + c.mnd + "</mnd>\n");
            fw.append("    <mag>" + c.mag + "</mag>\n");
            fw.append("    <asp>" + c.asp + "</asp>\n");
            fw.append("    <power>" + c.power + "</power>\n");
            fw.append("    <safety>" + c.safety + "</safety>\n");
            fw.append("    <knowledge>" + c.knowledge + "</knowledge>\n");
            fw.append("    <aspect>" + c.aspect + "</aspect>\n");
            fw.append("    <claspect>" + c.claspect + "</claspect>\n");
            fw.append("    <title>" + c.title + "</title>\n");
            fw.append("    <currentHp>" + c.currentHp + "</currentHp>\n");
            fw.append("    <weaponProf>" + c.weaponProf + "</weaponProf>\n");
            for (String skillProficiency : c.skillProficiencies) {
                fw.append("    <skillProf>" + skillProficiency + "</skillProf>\n");
            }
            for (Pair<String, Integer> p : c.gristCache) {
                fw.append("    <grist>\n");
                fw.append("        <type>" + p.getKey() + "</type>\n");
                fw.append("        <quantity>" + p.getValue() + "</quantity>\n");
                fw.append("    </grist>\n");
            }
            fw.append("    <equiped>" + c.equiped.name + "</equiped>\n");
            for (Armour armour : c.armourpodes) {
                fw.append("    <armour>\n");
                fw.append("        <name>" + armour.name + "</name>\n");
                fw.append("        <acBonus>" + armour.acBonus + "</acBonus>\n");
                fw.append("        <maxDexMod>" + armour.maxDexMod + "</maxDexMod>\n");
                fw.append("    </armour>\n");
            }
            for (Weapon weapon : c.weapons) {
                fw.append("    <weapon>\n");
                fw.append("        <name>" + weapon.name + "</name>\n");
                fw.append("        <type>" + weapon.type + "</type>\n");
                for (Attack attack : weapon.attacks) {
                    if (attack.straightDamage) {
                        fw.append("        <attack>\n");
                        fw.append("            <name>" + attack.name + "</name>\n");
                        fw.append("            <damage>" + attack.dmg + "</damage>\n");
                        fw.append("        </attack>\n");
                    } else {
                        fw.append("        <attack>\n");
                        fw.append("            <name>" + attack.name + "</name>\n");
                        fw.append("            <hitBonus>" + attack.hitBonus + "</hitBonus>\n");
                        fw.append("            <damage>" + attack.dmg + "</damage>\n");
                        fw.append("            <crit>" + attack.crit + "</crit>\n");
                        fw.append("            <critMul>" + attack.critMul + "</critMul>\n");
                        fw.append("            <ability>" + attack.abi + "</ability>\n");
                        if (attack.damageAdvantage) {
                            fw.append("            <bonus>damageAdvantage</bonus>\n");
                        }
                        fw.append("        </attack>\n");
                    }
                }
                fw.append("    </weapon>\n");
            }
            for (String[] technique : c.techniques) {
                fw.append("    <technique>\n");
                fw.append("        <name>" + technique[0] + "</name>\n");
                fw.append("        <source>" + technique[1] + "</source>\n");
                fw.append("        <description>" + technique[2] + "</description>\n");
                fw.append("    </technique>\n");
            }
            for (Entry<String, Integer> entry : c.resources.entrySet()) {
                fw.append("    <resource>\n");
                fw.append("        <name>" + entry.getKey() + "</name>\n");
                fw.append("        <value>" + entry.getValue() + "</value>\n");
                fw.append("    </resource>\n");
            }
            for (String string : c.onRollFunctions.keySet()) {
                fw.append("    <onRoll>" + string + "</onRoll>\n");
            }
            fw.append("</character>");
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window().setVisible(true);
            }
        });
    }

    public class JCanvas extends JPanel {

        public JCanvas(int x, int y, int w, int h, Window frame) {
            setLocation(x, y);
            setSize(w, h);
            addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e) {
                    int s = Integer.parseInt((String) JOptionPane.showInputDialog(frame, "Enter a health mod:", "Input required", JOptionPane.PLAIN_MESSAGE, null, null, ""));

                    HPTextField.setText((Integer.parseInt(HPTextField.getText()) + s) + "");

                    if (Integer.parseInt(HPTextField.getText()) < 0) {
                        if (rollDeathSave(s)) {
                            if (s < 0) {
                                HPTextField.setText((Integer.parseInt(HPTextField.getText()) - s) + "");
                            }
                        }
                    }
                }

                public void mousePressed(MouseEvent e) {

                }

                public void mouseReleased(MouseEvent e) {

                }

                public void mouseEntered(MouseEvent e) {

                }

                public void mouseExited(MouseEvent e) {

                }
            });
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.white);
            g.fillRect(0, 0, getWidth(), getHeight());

            try {
                int width = (int) (getWidth() * ((Integer.parseInt(HPTextField.getText()) + 0.0) / (Integer.parseInt(totalHPTextField.getText()) + 0.0)));
                g.setColor(Color.red);
                if (width > 0) {
                    g.setColor(Color.green);
                }
                g.fillRect(0, 0, Math.abs(width), getHeight());
            } catch (Exception e) {

            }

            g.setColor(Color.GRAY);
            double segment = (getWidth() + 0.0) / (Integer.parseInt(totalHPTextField.getText()) + 0.0);
            int segmentSize = (Integer.parseInt(totalHPTextField.getText()) / 50) + 1;
            for (int i = segmentSize; i < Integer.parseInt(totalHPTextField.getText()); i = i + segmentSize) {
                g.drawLine((int) (segment * i), 0, (int) (segment * i), getHeight());
            }
            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        }
    }

    private static class JTableButtonRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JButton button = (JButton) value;
            return button;
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField HPTextField;
    private javax.swing.JLabel acLabel;
    private javax.swing.JTextField acTextField;
    private javax.swing.JLabel advLabel;
    private javax.swing.JSpinner advSpinner;
    private javax.swing.JLabel armourLabel;
    private javax.swing.JPanel armourListPanel;
    private javax.swing.JPanel armourPanel;
    private javax.swing.JLabel aspLabel;
    private javax.swing.JTextField aspModTextField;
    private javax.swing.JTextField aspStatTextField;
    private javax.swing.JLabel aspectLabel;
    private javax.swing.JSpinner aspectSpinner;
    private javax.swing.JLabel attacksLabel;
    private javax.swing.JPanel attacksListPanel;
    private javax.swing.JPanel attacksPanel;
    private javax.swing.JPanel attributePanel;
    private javax.swing.JLabel attributesLabel;
    private javax.swing.JLabel bodLabel;
    private javax.swing.JTextField bodModTextField;
    private javax.swing.JTextField bodStatTextField;
    private javax.swing.JComboBox<String> characterComboBox;
    private javax.swing.JPanel characterPanel;
    private javax.swing.JScrollPane characterScrollPane;
    private javax.swing.JLabel claspectLabel;
    private javax.swing.JTextField claspectTextField;
    private javax.swing.JLabel deathsaveLabel;
    private javax.swing.JLabel dexLabel;
    private javax.swing.JTextField dexModTextField;
    private javax.swing.JTextField dexStatTextField;
    private javax.swing.JLabel diceRollerLabel;
    private javax.swing.JTextField diceRollerTextField;
    private javax.swing.JComboBox<String> gristCacheComboBox;
    private javax.swing.JLabel gristCacheLabel;
    private javax.swing.JPanel gristCachePanel;
    private javax.swing.JSpinner gristCacheSpinner;
    private javax.swing.JLabel hpDividerLabel;
    private javax.swing.JLabel hpLabel;
    private javax.swing.JLabel knowledgeLabel;
    private javax.swing.JSpinner knowledgeSpinner;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JPanel levelPanel;
    private javax.swing.JTextField levelTextField;
    private javax.swing.JLabel levelsLabel;
    private javax.swing.JButton loadButton;
    private javax.swing.JPanel lootRollerPanel;
    private javax.swing.JScrollPane lootRollerScrollPane;
    private javax.swing.JLabel magLabel;
    private javax.swing.JTextField magModTextField;
    private javax.swing.JTextField magStatTextField;
    private javax.swing.JTabbedPane mainTabPane;
    private javax.swing.JLabel mndLabel;
    private javax.swing.JTextField mndModTextField;
    private javax.swing.JTextField mndStatTextField;
    private javax.swing.JButton monsterLootButton;
    private javax.swing.JTable monsterLootTable;
    private javax.swing.JScrollPane monsterLootTableScrollPane;
    private javax.swing.JButton newButton;
    private javax.swing.JButton newGristButton;
    private javax.swing.JCheckBox outputCheckbox;
    private javax.swing.JScrollPane outputScrollPane;
    private javax.swing.JTextArea outputTextArea;
    private javax.swing.JLabel powerLabel;
    private javax.swing.JSpinner powerSpinner;
    private javax.swing.JLabel profLabel;
    private javax.swing.JTextField profTextField;
    private javax.swing.JCheckBox proficiencyCheckbox;
    private javax.swing.JPanel proficiencyPanel;
    private javax.swing.JPanel resourcePanel;
    private javax.swing.JLabel resourcesLabel;
    private javax.swing.JPanel resourcesListPanel;
    private javax.swing.JLabel safetyLabel;
    private javax.swing.JSpinner safetySpinner;
    private javax.swing.JSeparator seperator1;
    private javax.swing.JButton skillProfButton;
    private javax.swing.JPanel skillProficienciesPanel;
    private javax.swing.JLabel skillProficiencyLabel;
    private javax.swing.JLabel techniqueLabel;
    private javax.swing.JPanel techniqueListPanel;
    private javax.swing.JPanel techniquePanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField titleTextField;
    private javax.swing.JTextField totalHPTextField;
    private javax.swing.JLabel weaponKindLabel;
    private javax.swing.JLabel weaponProficiencyLabel;
    private javax.swing.JTextField weaponProficiencyTextField;
    // End of variables declaration//GEN-END:variables
}
