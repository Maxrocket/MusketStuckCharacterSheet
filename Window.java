package musketstuckcharactersheet;

import musketstuckcharactersheet.ui.WeaponListElement;
import musketstuckcharactersheet.ui.ArmourListElement;
import musketstuckcharactersheet.structures.Monster;
import musketstuckcharactersheet.structures.Armour;
import musketstuckcharactersheet.structures.Weapon;
import musketstuckcharactersheet.structures.Attack;
import musketstuckcharactersheet.structures.Character;
import musketstuckcharactersheet.structures.Dice;
import com.sun.glass.events.KeyEvent;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Window extends javax.swing.JFrame {

    public HashMap<String, Monster> monsters;
    public HashMap<String, JTextField> modRef;
    public HashMap<String, JTextField> statRef;
    public HashMap<String, JLabel> labelRef;

    public HashMap<String, Character> characters;
    public String currentSelection;
    public int currentGrist;
    public ArrayList<ArmourListElement> armourElements;
    public ArrayList<WeaponListElement> attackElements;

    public JCanvas healthBar;
    public JSpinner advantage;
    public JTextField prof;

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
        lootRollerScrollPane = new javax.swing.JScrollPane();
        lootRollerPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        seperator1 = new javax.swing.JSeparator();

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

        outputTextArea.setColumns(20);
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

        HPTextField.setText("46");
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
        profTextField.setBounds(295, 145, 45, 30);

        acLabel.setText("AC:");
        characterPanel.add(acLabel);
        acLabel.setBounds(360, 145, 21, 30);

        acTextField.setEditable(false);
        acTextField.setText("auto");
        characterPanel.add(acTextField);
        acTextField.setBounds(390, 145, 45, 30);

        attributePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        attributePanel.setLayout(null);

        bodLabel.setText("BOD: ");
        attributePanel.add(bodLabel);
        bodLabel.setBounds(20, 40, 33, 30);

        bodStatTextField.setText("12");
        attributePanel.add(bodStatTextField);
        bodStatTextField.setBounds(60, 40, 45, 30);

        bodModTextField.setEditable(false);
        bodModTextField.setText("auto");
        attributePanel.add(bodModTextField);
        bodModTextField.setBounds(115, 40, 45, 30);

        dexLabel.setText("DEX:");
        attributePanel.add(dexLabel);
        dexLabel.setBounds(20, 80, 28, 30);

        dexStatTextField.setText("18");
        attributePanel.add(dexStatTextField);
        dexStatTextField.setBounds(60, 80, 45, 30);

        dexModTextField.setEditable(false);
        dexModTextField.setText("auto");
        attributePanel.add(dexModTextField);
        dexModTextField.setBounds(115, 80, 45, 30);

        mndLabel.setText("MND:");
        attributePanel.add(mndLabel);
        mndLabel.setBounds(20, 120, 31, 30);

        mndStatTextField.setText("12");
        attributePanel.add(mndStatTextField);
        mndStatTextField.setBounds(60, 120, 45, 30);

        mndModTextField.setEditable(false);
        mndModTextField.setText("auto");
        attributePanel.add(mndModTextField);
        mndModTextField.setBounds(115, 120, 45, 30);

        magLabel.setText("MAG:");
        attributePanel.add(magLabel);
        magLabel.setBounds(20, 160, 31, 30);

        magStatTextField.setText("8");
        magStatTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                magStatTextFieldActionPerformed(evt);
            }
        });
        attributePanel.add(magStatTextField);
        magStatTextField.setBounds(60, 160, 45, 30);

        magModTextField.setEditable(false);
        magModTextField.setText("auto");
        attributePanel.add(magModTextField);
        magModTextField.setBounds(115, 160, 45, 30);

        aspLabel.setText("ASP:");
        attributePanel.add(aspLabel);
        aspLabel.setBounds(20, 200, 28, 30);

        aspStatTextField.setText("14");
        attributePanel.add(aspStatTextField);
        aspStatTextField.setBounds(60, 200, 45, 30);

        aspModTextField.setEditable(false);
        aspModTextField.setText("auto");
        attributePanel.add(aspModTextField);
        aspModTextField.setBounds(115, 200, 45, 30);

        attributesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        attributesLabel.setText("Attributes");
        attributePanel.add(attributesLabel);
        attributesLabel.setBounds(10, 10, 160, 16);

        characterPanel.add(attributePanel);
        attributePanel.setBounds(20, 140, 180, 250);

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

        profLabel.setText("Prof Bonus:");
        characterPanel.add(profLabel);
        profLabel.setBounds(220, 145, 70, 30);

        claspectLabel.setText("Claspect: ");
        characterPanel.add(claspectLabel);
        claspectLabel.setBounds(20, 60, 60, 30);

        claspectTextField.setText("Heir Of Void");
        characterPanel.add(claspectTextField);
        claspectTextField.setBounds(90, 60, 110, 30);

        titleLabel.setText("Title:");
        characterPanel.add(titleLabel);
        titleLabel.setBounds(220, 60, 40, 30);

        titleTextField.setText("Heir Of Void");
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

        powerSpinner.setModel(new javax.swing.SpinnerNumberModel(5, 0, null, 1));
        levelPanel.add(powerSpinner);
        powerSpinner.setBounds(100, 40, 45, 30);

        knowledgeLabel.setText("Knowledge:");
        levelPanel.add(knowledgeLabel);
        knowledgeLabel.setBounds(175, 40, 67, 30);

        knowledgeSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 0, null, 1));
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
        gristCachePanel.setBounds(20, 410, 180, 165);

        armourPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        armourPanel.setLayout(null);

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

        characterScrollPane.setViewportView(characterPanel);

        mainTabPane.addTab("Character Sheet", characterScrollPane);

        lootRollerScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        lootRollerPanel.setMinimumSize(new java.awt.Dimension(0, 1000));
        lootRollerPanel.setPreferredSize(new java.awt.Dimension(560, 1000));
        lootRollerPanel.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
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
        jScrollPane1.setViewportView(jTable1);

        lootRollerPanel.add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 540, 270);

        lootRollerScrollPane.setViewportView(lootRollerPanel);

        mainTabPane.addTab("Loot Roller", lootRollerScrollPane);

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
                        .addGap(0, 0, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outputCheckbox)
                    .addComponent(advLabel)
                    .addComponent(advSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                fw.append("    <character>\n");
                fw.append("        <name>" + s + "</name>\n");
                fw.append("        <file>" + s.toLowerCase() + ".xml</file>\n");
                fw.append("    </character>\n");
                fw.append("</main>");
                fw.flush();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            }
            Character c = new Character(s, 10, 10, 10, 10, 10, 0, 0, 0, 0, "", "", 10);
            c.addGrist("Build Grist", 0);
            c.addGrist("Abstraction Grist", 0);
            characterComboBox.addItem(s);
            characters.put(s, c);
            selectedCharacter = s;
            saveCharacter(c);
        } else {
            Document startup = parseXML("data/startup.xml");
            startup.getDocumentElement().normalize();
            NodeList nl = startup.getDocumentElement().getElementsByTagName("character");
            for (int i = 0; i < nl.getLength(); i++) {
                Element e = (Element) nl.item(i);
                characterComboBox.addItem(e.getElementsByTagName("name").item(0).getTextContent());

                Document charDoc = parseXML("data/characters/" + e.getElementsByTagName("file").item(0).getTextContent());
                charDoc.getDocumentElement().normalize();
                Element s = (Element) charDoc.getDocumentElement();
                Character character = new Character(s.getElementsByTagName("name").item(0).getTextContent(),
                        Integer.parseInt(s.getElementsByTagName("bod").item(0).getTextContent()),
                        Integer.parseInt(s.getElementsByTagName("dex").item(0).getTextContent()),
                        Integer.parseInt(s.getElementsByTagName("mnd").item(0).getTextContent()),
                        Integer.parseInt(s.getElementsByTagName("mag").item(0).getTextContent()),
                        Integer.parseInt(s.getElementsByTagName("asp").item(0).getTextContent()),
                        Integer.parseInt(s.getElementsByTagName("power").item(0).getTextContent()),
                        Integer.parseInt(s.getElementsByTagName("safety").item(0).getTextContent()),
                        Integer.parseInt(s.getElementsByTagName("knowledge").item(0).getTextContent()),
                        Integer.parseInt(s.getElementsByTagName("aspect").item(0).getTextContent()),
                        s.getElementsByTagName("claspect").item(0).getTextContent(),
                        s.getElementsByTagName("title").item(0).getTextContent(),
                        Integer.parseInt(s.getElementsByTagName("currentHp").item(0).getTextContent()));

                NodeList gristCache = s.getElementsByTagName("grist");
                for (int j = 0; j < gristCache.getLength(); j++) {
                    Element grist = (Element) gristCache.item(j);
                    character.addGrist(grist.getElementsByTagName("type").item(0).getTextContent(),
                            Integer.parseInt(grist.getElementsByTagName("quantity").item(0).getTextContent()));
                }

                NodeList armours = s.getElementsByTagName("armour");
                for (int j = 0; j < armours.getLength(); j++) {
                    Element armour = (Element) armours.item(j);
                    Armour armourItem = new Armour(armour.getElementsByTagName("name").item(0).getTextContent(),
                            Integer.parseInt(armour.getElementsByTagName("acBonus").item(0).getTextContent()),
                            Integer.parseInt(armour.getElementsByTagName("maxDexMod").item(0).getTextContent()));
                    character.addItem(armourItem);
                    if (s.getElementsByTagName("equiped").item(0).getTextContent().equals(armour.getElementsByTagName("name").item(0).getTextContent())) {
                        character.equiped = armourItem;
                    }
                }

                NodeList weapons = s.getElementsByTagName("weapon");
                for (int j = 0; j < weapons.getLength(); j++) {
                    Element weapon = (Element) weapons.item(j);

                    ArrayList<Attack> attackList = new ArrayList();
                    NodeList attacks = s.getElementsByTagName("attack");
                    
                    NodeList something = s.getChildNodes();
                    for (int k = 0; k < something.getLength(); k++) {
                        System.out.println(something.item(k));
                    }
                    
                    for (int k = 0; k < attacks.getLength(); k++) {
                        Element attack = (Element) attacks.item(k);

                        Attack attackItem = new Attack(attack.getElementsByTagName("name").item(0).getTextContent(),
                                Integer.parseInt(attack.getElementsByTagName("hitBonus").item(0).getTextContent()),
                                attack.getElementsByTagName("damage").item(0).getTextContent(),
                                attack.getElementsByTagName("bonusDamage").item(0).getTextContent(),
                                Integer.parseInt(attack.getElementsByTagName("crit").item(0).getTextContent()),
                                Integer.parseInt(attack.getElementsByTagName("critMul").item(0).getTextContent()),
                                attack.getElementsByTagName("ability").item(0).getTextContent());
                        attackItem.setDamageAdvantage(true);
                        attackList.add(attackItem);
                    }
                    NodeList damages = s.getElementsByTagName("direct");
                    for (int k = 0; k < damages.getLength(); k++) {
                        Element damage = (Element) damages.item(k);

                        Attack attackItem = new Attack(damage.getElementsByTagName("name").item(0).getTextContent(),
                                damage.getElementsByTagName("damage").item(0).getTextContent());
                        attackList.add(attackItem);
                    }

                    Weapon weaponItem = new Weapon(weapon.getElementsByTagName("name").item(0).getTextContent(), attackList);
                    character.addItem(weaponItem);
                }

                characters.put(s.getElementsByTagName("name").item(0).getTextContent(), character);
            }
            selectedCharacter = startup.getDocumentElement().getElementsByTagName("default").item(0).getTextContent();
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

        /*
        OnRoll doubleOnes = new OnRoll() {
            @Override
            public Pair<String[], int[]> onRoll(Pair<String[], int[]> rolls, int num, int type) {
                while (Dice.count(1, rolls.getValue()) >= 2) {
                    for (int i = 0; i < num; i++) {
                        if (rolls.getValue()[i] == 1) {
                            rolls.getValue()[i] = type;
                            rolls.getKey()[i] = rolls.getKey()[i] + " [" + type + "]";
                            break;
                        }
                    }
                    for (int i = 0; i < num; i++) {
                        if (rolls.getValue()[i] == 1) {
                            rolls.getValue()[i] = type;
                            rolls.getKey()[i] = rolls.getKey()[i] + " [" + type + "]";
                            break;
                        }
                    }
                }
                if (Dice.count(1, rolls.getValue()) == 1) {
                    for (int i = 0; i < num; i++) {
                        if (rolls.getValue()[i] == 1) {
                            int d6 = (int) Math.ceil(Math.random() * 6.0);
                            if (d6 == 1) {
                                rolls.getValue()[i] = type;
                                rolls.getKey()[i] = rolls.getKey()[i] + " (" + d6 + ")[" + type + "]";
                            } else {
                                rolls.getKey()[i] = rolls.getKey()[i] + " (" + d6 + ")";
                            }
                            break;
                        }
                    }
                }
                return rolls;
            }
        };
        characters.get("Doot").addOnRoll(doubleOnes); */
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
                    Pair<String[], int[]> hitRolls = Dice.roll(1 + Math.abs((int) advSpinner.getValue()), 20, characters.get(characterComboBox.getSelectedItem()).getOnRollFunctions());
                    int toHit = hitRolls.getValue()[0];
                    if ((int) advSpinner.getValue() > 0) {
                        toHit = Dice.advantage(hitRolls.getValue());
                    }
                    if ((int) advSpinner.getValue() < 0) {
                        toHit = Dice.disadvantage(hitRolls.getValue());
                    }
                    int result = toHit + Integer.parseInt(modRef.get(string).getText());

                    outputText(string + " Roll: " + Dice.writeDiceResult(hitRolls.getKey()) + "+" + modRef.get(string).getText() + "=" + result + "\n",
                            string + " Roll: ```" + Dice.writeDiceResult(hitRolls.getKey()) + "+" + modRef.get(string).getText() + "=" + result + "```");
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

        monsters = new HashMap();

        Monster imp = new Monster("Imp");
        imp.addLoot("Build Grist", "1d10");
        imp.addLoot("Abstraction Grist", "1d10");
        monsters.put("Imp", imp);
        Monster orc = new Monster("Orc");
        orc.addLoot("Build Grist", "2d20");
        orc.addLoot("Abstraction Grist", "2d20");
        orc.addLoot("Shale", "1d5");
        monsters.put("Orc", orc);
        Monster ogre = new Monster("Ogre");
        ogre.addLoot("Build Grist", "20d12");
        ogre.addLoot("Abstraction Grist", "20d12");
        ogre.addLoot("Shale", "10d6");
        ogre.addLoot("Rubies", "1d10");
        monsters.put("Ogre", ogre);

//        for (String string : weapons.keySet()) {
//            weaponSelect.addItem(string);
//        }

    }//GEN-LAST:event_formWindowOpened

    private void magStatTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_magStatTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_magStatTextFieldActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        save(characters.get(currentSelection));
        try {
            FileWriter fw = new FileWriter("data/startup.xml");
            fw.write("<main>\n");
            fw.append("    <default>" + currentSelection + "</default>\n");
            for (Character value : characters.values()) {
                fw.append("    <character>\n");
                fw.append("        <name>" + value.name + "</name>\n");
                fw.append("        <file>" + value.name.toLowerCase() + ".xml</file>\n");
                fw.append("    </character>\n");
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
            Character c = new Character(s, 10, 10, 10, 10, 10, 0, 0, 0, 0, "", "", 10);
            c.addGrist("Build Grist", 0);
            c.addGrist("Abstraction Grist", 0);
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

    public void rollDeathSave() {
        rollDeathSave(0);
    }

    public boolean rollDeathSave(int s) {
        Pair<String[], int[]> hitRolls = Dice.roll(1 + Math.abs((int) advSpinner.getValue()), 20, characters.get(characterComboBox.getSelectedItem()).getOnRollFunctions());
        int toHit = hitRolls.getValue()[0];
        if ((int) advSpinner.getValue() > 0) {
            toHit = Dice.advantage(hitRolls.getValue());
        }
        if ((int) advSpinner.getValue() < 0) {
            toHit = Dice.disadvantage(hitRolls.getValue());
        }
        int result = toHit + Integer.parseInt(modRef.get("BOD").getText());

        String rollResult = "FAILIURE";
        boolean crit = false;
        if (toHit == 20) {
            rollResult = "CRITICAL SUCCESS, DAMAGE AVOIDED";
            crit = true;
        } else {
            if (result >= Integer.parseInt(HPTextField.getText()) * -1) {
                rollResult = "SUCCESS";
            }
        }

        outputText("Death Save: " + Dice.writeDiceResult(hitRolls.getKey()) + "+" + modRef.get("BOD").getText() + "=" + result + " " + rollResult + "\n",
                "Death Save: ```" + Dice.writeDiceResult(hitRolls.getKey()) + "+" + modRef.get("BOD").getText() + "=" + result + " " + rollResult + "```");
        return crit;
    }

    public void outputText(String text, String discord) {
        if (outputCheckbox.isSelected()) {
            try {
                MouseCorrectRobot r = new MouseCorrectRobot();

                r.keyPress(KeyEvent.VK_ALT);
                r.keyPress(KeyEvent.VK_TAB);
                r.delay(50);
                r.keyRelease(KeyEvent.VK_ALT);
                r.keyRelease(KeyEvent.VK_TAB);
                r.MoveMouseControlled(0, 0);
                r.MoveMouseControlled(0.25, 0.9);
                int mask1 = InputEvent.getMaskForButton(1);
                r.mousePress(mask1);
                r.delay(50);
                r.mouseRelease(mask1);
                r.delay(50);

                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                StringSelection stringSelection = new StringSelection(discord);
                clipboard.setContents(stringSelection, stringSelection);
                r.delay(50);

                r.keyPress(KeyEvent.VK_CONTROL);
                r.keyPress(KeyEvent.VK_V);
                r.delay(50);
                r.keyRelease(KeyEvent.VK_V);
                r.keyRelease(KeyEvent.VK_CONTROL);
                r.delay(50);
                r.keyPress(KeyEvent.VK_ENTER);
                r.delay(50);
                r.keyRelease(KeyEvent.VK_ENTER);
                r.delay(50);
                r.keyPress(KeyEvent.VK_ALT);
                r.keyPress(KeyEvent.VK_TAB);
                r.keyRelease(KeyEvent.VK_ALT);
                r.keyRelease(KeyEvent.VK_TAB);

            } catch (AWTException ex) {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            outputTextArea.append(text);
            outputTextArea.append("------------------------------\n");
        }
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

    public Document parseXML(String filepath) {
        String fileContent = "";
        try {
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            fileContent += line;
            line = br.readLine();
            while (line != null) {
                fileContent += "\n" + line;
                line = br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }

        Document doc = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            StringBuilder xmlStringBuilder = new StringBuilder();
            xmlStringBuilder.append(fileContent);
            ByteArrayInputStream input = new ByteArrayInputStream(xmlStringBuilder.toString().getBytes("UTF-8"));
            doc = builder.parse(input);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doc;
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
        for (int i = 0; i < c.weapons.size(); i++) {
            yCount += 10;
            WeaponListElement element = new WeaponListElement(yCount, 280, this, c.weapons.get(i));
            attacksListPanel.add(element);
            attackElements.add(element);
            yCount += element.getHeight();
        }
        attacksListPanel.setSize(280, yCount);
        attacksPanel.setSize(320, 50 + yCount);

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

            String gristName = c.gristCache.get(currentGrist).getKey();
            c.gristCache.remove(currentGrist);
            c.gristCache.add(currentGrist, new Pair(gristName, gristCacheSpinner.getValue()));

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
                for (Attack attack : weapon.attacks) {
                    if (attack.straightDamage) {
                        fw.append("        <direct>\n");
                        fw.append("            <name>" + attack.name + "</name>\n");
                        fw.append("            <damage>" + attack.dmg.get(0).getKey() + "d" + attack.dmg.get(0).getValue());
                        for (int i = 1; i < attack.dmg.size(); i++) {
                            fw.append("+" + attack.dmg.get(i).getKey() + "d" + attack.dmg.get(i).getValue());
                        }
                        fw.append("</damage>\n");
                        fw.append("        </direct>\n");
                    } else {
                        fw.append("        <attack>\n");
                        fw.append("            <name>" + attack.name + "</name>\n");
                        fw.append("            <hitBonus>" + attack.hitBonus + "</hitBonus>\n");
                        fw.append("            <damage>" + attack.dmg.get(0).getKey() + "d" + attack.dmg.get(0).getValue());
                        for (int i = 1; i < attack.dmg.size(); i++) {
                            fw.append("+" + attack.dmg.get(i).getKey() + "d" + attack.dmg.get(i).getValue());
                        }
                        fw.append("</damage>\n");
                        fw.append("            <bonusDamage>");
                        if (attack.bonusDmg.size() > 0) {
                            fw.append(attack.bonusDmg.get(0).getKey() + "d" + attack.bonusDmg.get(0).getValue());
                            for (int i = 1; i < attack.bonusDmg.size(); i++) {
                                fw.append("+" + attack.bonusDmg.get(i).getKey() + "d" + attack.bonusDmg.get(i).getValue());
                            }
                        }
                        fw.append("</bonusDamage>\n");
                        fw.append("            <crit>" + attack.crit + "</crit>\n");
                        fw.append("            <critMul>" + attack.critMul + "</critMul>\n");
                        fw.append("            <ability>" + attack.abi + "</ability>\n");

                        fw.append("        </attack>\n");
                    }
                }
                fw.append("    </weapon>\n");
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
            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
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
    private javax.swing.JComboBox<String> gristCacheComboBox;
    private javax.swing.JLabel gristCacheLabel;
    private javax.swing.JPanel gristCachePanel;
    private javax.swing.JSpinner gristCacheSpinner;
    private javax.swing.JLabel hpDividerLabel;
    private javax.swing.JLabel hpLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
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
    private javax.swing.JButton newButton;
    private javax.swing.JButton newGristButton;
    private javax.swing.JCheckBox outputCheckbox;
    private javax.swing.JScrollPane outputScrollPane;
    private javax.swing.JTextArea outputTextArea;
    private javax.swing.JLabel powerLabel;
    private javax.swing.JSpinner powerSpinner;
    private javax.swing.JLabel profLabel;
    private javax.swing.JTextField profTextField;
    private javax.swing.JLabel safetyLabel;
    private javax.swing.JSpinner safetySpinner;
    private javax.swing.JSeparator seperator1;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField titleTextField;
    private javax.swing.JTextField totalHPTextField;
    // End of variables declaration//GEN-END:variables
}
