/* === NOTES ===
 * jcboDuration may be changed to jsDuration (into a spinner), but we need to find a way to limit the number

 * === HELPFUL LINKS ===
 * https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html
 * https://docs.oracle.com/javase/tutorial/jdbc/basics/connecting.html#db_connection_url
 * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html
 */
package hmjcalc;

//import hmjcalc.objects.Drink;
import hmjcalc.objects.Person;
import static hmjcalc.sqlTools.printSQLException;
import java.util.*;
import java.awt.FlowLayout;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.*;
//will need to import API stuff here

/**
 *
 * @author Harrison, Alex
 */
public class HMJGUI extends javax.swing.JFrame {

    private Person user = null;
    //Locale information; may be deleted later on
    Locale usEnglish = Locale.forLanguageTag("en-US");
    Locale mxSpanish = Locale.forLanguageTag("es-MX");
    Locale chChinese = Locale.forLanguageTag("zh-CN");
    //String getdisplayLanguage(Locale usEnglish);

    //Lists for the SQL drink fields
    List<String> drinkNames = new ArrayList<>();
    List<String> drinkAbvs = new ArrayList<>();
    List<String> drinkVols = new ArrayList<>();
    List<String> bars = new ArrayList<>();
    Connection conn = null; //leave null until we build our database
    DefaultComboBoxModel dModel;
    //Go here for help: https://docs.oracle.com/javase/tutorial/jdbc/basics/connecting.html#db_connection_url

    /**
     * Creates new form HMJGUI
     */
    public HMJGUI() {
        initComponents();
        user = new Person();

        /*timeHandler th = new timeHandler();
        th.main(); //we need to run the main method somehow*/
        //See if we can thread this from timeHandler if we get time
        //Maybe look here: https://stackoverflow.com/questions/24770094/calling-a-class-from-another-class-with-main-method
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("timezonedb.xml");
            //zoneName will be the unique identifier
            NodeList zList = doc.getElementsByTagName("zoneName");
            NodeList tList = doc.getElementsByTagName("timestamp");
            for (int i = 0; i < zList.getLength(); i++) {
                Node z = zList.item(i);
                Node t = tList.item(i);
                //only need to loop through one item
                if (z.getNodeType() == Node.ELEMENT_NODE) {
                    Element zt = (Element) z;
                    Element tt = (Element) t;
                    long num = Long.valueOf(tt.getTextContent());
                    java.util.Date time = new java.util.Date((long) num * 1000);
                    String hour = time.toString().substring(11, 13);
                    if (hour.equals("17")) {
                        jta5Oclock.append(zt.getTextContent() + "\n");
                    }
                }
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(timeHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(timeHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(timeHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*public class HelloThread extends Thread {
        public void run() {
        System.out.println("Hello from a thread!"); }
        public static void main(String args[]) {
        (new HelloThread()).start();
        }
        }*/

        String barNames[] = {"Harry's",
            "Brother's Bar & Grill", "Neon Cactus",
            "Hunters Pub", "The Pint", "Klondike Pub", "Nine Irish Brothers",
            "Stacked Pickle", "Echo Karaoke", "308 On State", "Scotty's Brewhouse",
            "Knickerbocker Saloon", "Black Sparrow", "Double Deuce Saloon", "Local Bar",
            "Sgt Preston's of the North", "RedSeven Bar & Grill",
            "Lafayette Brewing Company", "DT Kirby's", "Blind Pig"};
        DefaultComboBoxModel bModel = new DefaultComboBoxModel(barNames);
        jcboBar.setModel(bModel);
    }

    //FOR USE WITH THE JDBC/SQL DATABASE; HAS NOT BEEN TESTED
    //REF: https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html
    public void getDrinks(Connection con, String tableName, String idName, String drinkSID)
            throws SQLException {

        Statement stmt = null;
        //NOTE: dbName is a placeholder for whatever our database is going to be called
        String query = "SELECT DrinkName, DrinkAbv, Volume FROM dbName." + tableName
                + " WHERE" + idName + "=" + drinkSID;
        try {
            drinkNames.clear();
            drinkAbvs.clear();
            drinkVols.clear();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                drinkNames.add(rs.getString("DrinkName"));
                drinkAbvs.add(rs.getString("DrinkAbv"));
                drinkVols.add(rs.getString("Volume"));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jlSex = new javax.swing.JLabel();
        jlAge = new javax.swing.JLabel();
        jcboSex = new javax.swing.JComboBox<>();
        jlLanguage = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jsAge = new javax.swing.JSpinner();
        jlWeight = new javax.swing.JLabel();
        jsWeight = new javax.swing.JSpinner();
        jlDesired = new javax.swing.JLabel();
        jlDuration = new javax.swing.JLabel();
        jcboDuration = new javax.swing.JComboBox<>();
        jlTitle = new javax.swing.JLabel();
        jcboDesired = new javax.swing.JComboBox<>();
        jcboBar = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jlBarInfo = new javax.swing.JLabel();
        jlBar = new javax.swing.JLabel();
        jlDrinks = new javax.swing.JLabel();
        jlAContent = new javax.swing.JLabel();
        jbtnSave = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jbtnClear = new javax.swing.JButton();
        jlHMSID = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaHMSID = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaAContent = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jta5Oclock = new javax.swing.JTextArea();
        jcboDrinks = new javax.swing.JComboBox();
        jcboDrinksSub = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlSex.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jlSex.setText("Sex: ");

        jlAge.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jlAge.setText("Age: ");

        jcboSex.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jcboSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jlLanguage.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jlLanguage.setText("Language:");

        jComboBox1.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "English", "Spanish", "Chinese" }));

        jsAge.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N

        jlWeight.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jlWeight.setText("Weight: ");

        jsWeight.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N

        jlDesired.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jlDesired.setText("Desired Level of Drunkenness: ");

        jlDuration.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jlDuration.setText("Duration (in hours):");

        jcboDuration.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jcboDuration.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".5", "1", "1.5", "2", "2.5", "3", "3.5", "4", "4.5", "5", "5.5", "6", "6.5", "7", "7.5", "8" }));

        jlTitle.setFont(new java.awt.Font("Verdana", 3, 36)); // NOI18N
        jlTitle.setText("How Many Jrinks?");

        jcboDesired.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jcboDesired.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        jcboDesired.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcboDesiredActionPerformed(evt);
            }
        });

        jcboBar.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jcboBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcboBarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jLabel1.setText("It's 5 O'clock somewhere!");

        jlBarInfo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlBarInfo.setText("Bar Info");

        jlBar.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jlBar.setText("Bar:");

        jlDrinks.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jlDrinks.setText("Popular Drinks and Drink Specials: ");

        jlAContent.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jlAContent.setText("Alcohol Content");
        jlAContent.setToolTipText("");

        jbtnSave.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        jbtnSave.setText("Save");
        jbtnSave.setToolTipText("");
        jbtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveActionPerformed(evt);
            }
        });

        jbtnClear.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        jbtnClear.setText("Clear");
        jbtnClear.setToolTipText("");
        jbtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnClearActionPerformed(evt);
            }
        });

        jlHMSID.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jlHMSID.setText("How Many Should I Drink?");
        jlHMSID.setEnabled(false);
        jlHMSID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlHMSIDActionPerformed(evt);
            }
        });

        jtaHMSID.setColumns(20);
        jtaHMSID.setLineWrap(true);
        jtaHMSID.setRows(5);
        jScrollPane1.setViewportView(jtaHMSID);

        jtaAContent.setColumns(20);
        jtaAContent.setRows(5);
        jScrollPane2.setViewportView(jtaAContent);

        jta5Oclock.setEditable(false);
        jta5Oclock.setColumns(20);
        jta5Oclock.setLineWrap(true);
        jta5Oclock.setRows(5);
        jScrollPane4.setViewportView(jta5Oclock);

        jcboDrinks.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jcboDrinks.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All Drinks", "Beer", "Wine", "Hard Liquor", "All Mixed Drinks", "Well Drink", "Specialty Drink" }));
        jcboDrinks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcboDrinksActionPerformed(evt);
            }
        });

        jcboDrinksSub.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jcboDrinksSub.setEnabled(false);
        jcboDrinksSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcboDrinksSubActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlBarInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlTitle)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlDesired)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jcboDesired, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlDuration)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jcboDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlWeight)
                                            .addComponent(jlAge))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jsWeight)
                                            .addComponent(jsAge)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlSex)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jcboSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addComponent(jlLanguage)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlBar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcboBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jbtnClear)
                                        .addGap(221, 221, 221))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jbtnSave)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jlHMSID, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jlDrinks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jcboDrinks, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jcboDrinksSub, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jlAContent))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlTitle)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlSex)
                            .addComponent(jcboSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlLanguage)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlAge)
                            .addComponent(jsAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlWeight)
                            .addComponent(jsWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlDesired)
                            .addComponent(jcboDesired, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlDuration)
                            .addComponent(jcboDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlBarInfo)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlBar)
                    .addComponent(jcboBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDrinks)
                    .addComponent(jlAContent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcboDrinks, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcboDrinksSub, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jbtnSave)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtnClear))
                        .addComponent(jlHMSID, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    //maybe we should make a "Load" button to get information from the Person class when 
    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveActionPerformed
        Boolean isMale;
        isMale = jcboSex.getSelectedItem().toString().equals("Male");
        Person.setSex(isMale);
        Person.setAge(Integer.parseInt(jsAge.getValue().toString()));
        Person.setWeight(Integer.parseInt(jsWeight.getValue().toString()));
        Person.sethLD(Double.parseDouble(jcboDuration.getSelectedItem().toString()));
        Person.setDDrunk(Integer.parseInt(jcboDesired.getSelectedItem().toString()));
        jlHMSID.setEnabled(true);
    }//GEN-LAST:event_jbtnSaveActionPerformed

    private void jbtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnClearActionPerformed
        jcboSex.setSelectedItem("Male");
        jsAge.setValue(0);
        jsWeight.setValue(0);
        jcboDuration.setSelectedItem(0.5);
        jcboDesired.setSelectedItem("1");
    }//GEN-LAST:event_jbtnClearActionPerformed

    private void jcboDesiredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcboDesiredActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcboDesiredActionPerformed
    private void jcboBox2TextDisplay() { //prints ABV for a few drinks for display purposes
        //remove this
    }
    private void jlHMSIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlHMSIDActionPerformed
        double numberOfDrinks;
        if (Person.getAge() >= 21) { //should work with the textbox or display in JPanel
            numberOfDrinks = user.howManyShouldIDrink();
            jtaHMSID.setText("You should have " + numberOfDrinks + " Drinks");
        } else {
            jtaHMSID.setText("You are not old enough to drink. Try again later");
        }

    }//GEN-LAST:event_jlHMSIDActionPerformed

    private void jcboDrinksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcboDrinksActionPerformed
        jcboDrinksSub.setEnabled(true);
        String beer[] = {"Budweiser", "Samuel Adams", "Coors Lite"};
        String wine[] = {"French Roses", "Argentine Malbec", "California Zinfandel"};
        String hLiquor[] = {"Svedka", "Genevieve", "Jameson"};
        String wDrink[] = {"Rum and Coke", "Vodka Cranberry", "Tequila Cola"};
        String sDrink[] = {"Margarita", "Pisco Sour", "Bloody Mary"};
        //because ArrayUtils doesn't work anymore I guess
        String mDrink[] = {"Rum and Coke", "Vodka Cranberry", "Tequila Cola",
            "Margarita", "Pisco Sour", "Bloody Mary"};
        String aDrink[] = {"Budweiser", "Samuel Adams", "Coors Lite",
            "French Roses", "Argentine Malbec", "California Zinfandel", "Svedka",
            "Genevieve", "Jameson", "Rum and Coke", "Vodka Cranberry",
            "Tequila Cola", "Margarita", "Pisco Sour", "Bloody Mary"};
        ResultSet drinkset;
        //MOST OF THESE WILL THROW ERRORS BECAUSE THE DATABASE HAS NOT BEEN BUILT YET
        switch (jcboDrinks.getSelectedItem().toString()) {
            case "All Drinks":
                dModel = new DefaultComboBoxModel(aDrink);
                jcboDrinksSub.setModel(dModel);
                break;
            case "Beer":
                dModel = new DefaultComboBoxModel(beer);
                jcboDrinksSub.setModel(dModel);
                break;
            case "Wine":
                dModel = new DefaultComboBoxModel(wine);
                jcboDrinksSub.setModel(dModel);
                break;
            case "Hard Liquor":
                dModel = new DefaultComboBoxModel(hLiquor);
                jcboDrinksSub.setModel(dModel);
                break;
            case "All Mixed Drinks":
                dModel = new DefaultComboBoxModel(mDrink);
                jcboDrinksSub.setModel(dModel);
                break;
            case "Well Drink":
                dModel = new DefaultComboBoxModel(wDrink);
                jcboDrinksSub.setModel(dModel);
                break;
            case "Specialty Drink":
                dModel = new DefaultComboBoxModel(sDrink);
                jcboDrinksSub.setModel(dModel);
                break;
        }    }//GEN-LAST:event_jcboDrinksActionPerformed

    private void jcboBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcboBarActionPerformed
        //bars' menus will be defined here
        int counter = 0;
        /*for (int i = 0; i < bars.size(); i++) {
            if (bars<i> != null) {
                counter++;
            }
        }
        String drinks[] = {"Beer", "Wine", "Shot", "Mixed Drink"};
        DefaultComboBoxModel model2 = new DefaultComboBoxModel( drinks );
        jcboDrinks.setModel( model2 );*/
    }//GEN-LAST:event_jcboBarActionPerformed

    private void jcboDrinksSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcboDrinksSubActionPerformed
        switch (jcboDrinksSub.getSelectedItem().toString()) {
            case "Budweiser":
                jtaAContent.setText("4.1% ABV");
                break;
            case "Samuel Adams":
                jtaAContent.setText("5.4% ABV");
                break;
            case "Coors Lite":
                jtaAContent.setText("4.2% ABV");
                break;
            case "French Roses":
                jtaAContent.setText("12.7% ABV");
                break;
            case "Argentine Malbec":
                jtaAContent.setText("13.8% ABV");
                break;
            case "California Zinfandel":
                jtaAContent.setText("15% ABV");
                break;
            case "Genvieve":
                jtaAContent.setText("47.3% ABV");
                break;
            case "Jameson":
                jtaAContent.setText("40% ABV");
                break;
            case "Rum and Coke":
                jtaAContent.setText("12.7% ABV");
                break;
            case "Vodka Cranberry":
                jtaAContent.setText("18% ABV");
                break;
            case "Tequila Cola":
                jtaAContent.setText("18% ABV");
                break;
            case "Margarita":
                jtaAContent.setText("18% ABV");
                break;
            case "Pisco Sour":
                jtaAContent.setText("20% ABV");
                break;
            case "Bloody Mary":
                jtaAContent.setText("18% ABV");
                break;
        }
    }//GEN-LAST:event_jcboDrinksSubActionPerformed

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
            java.util.logging.Logger.getLogger(HMJGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HMJGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HMJGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HMJGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HMJGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jbtnClear;
    private javax.swing.JButton jbtnSave;
    private javax.swing.JComboBox<String> jcboBar;
    private javax.swing.JComboBox<String> jcboDesired;
    private javax.swing.JComboBox jcboDrinks;
    private javax.swing.JComboBox jcboDrinksSub;
    private javax.swing.JComboBox<String> jcboDuration;
    private javax.swing.JComboBox<String> jcboSex;
    private javax.swing.JLabel jlAContent;
    private javax.swing.JLabel jlAge;
    private javax.swing.JLabel jlBar;
    private javax.swing.JLabel jlBarInfo;
    private javax.swing.JLabel jlDesired;
    private javax.swing.JLabel jlDrinks;
    private javax.swing.JLabel jlDuration;
    private javax.swing.JButton jlHMSID;
    private javax.swing.JLabel jlLanguage;
    private javax.swing.JLabel jlSex;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JLabel jlWeight;
    private javax.swing.JSpinner jsAge;
    private javax.swing.JSpinner jsWeight;
    private javax.swing.JTextArea jta5Oclock;
    private javax.swing.JTextArea jtaAContent;
    private javax.swing.JTextArea jtaHMSID;
    // End of variables declaration//GEN-END:variables
}
