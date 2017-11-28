import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.util.Calendar;
/*  w w w .ja  v  a  2  s  .c o  m*/
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


class Month extends JPanel {
  int month;
  int year;
  protected String[] monthNames = { "January", "February", "March", "April",
      "May", "June", "July", "August", "September", "October", "November",
      "December" };

  protected String[] dayNames = { "S", "M", "T", "W", "T", "F", "S" };

  public Month(int month, int year) {
    this.month = month;
    this.year = year;
    JPanel Month = new JPanel(true);
    Month.setLayout(new BorderLayout());
    Month.add(createTitleGUI(), BorderLayout.NORTH);
    Month.add(createDaysGUI(), BorderLayout.SOUTH);
    this.add(Month);
  }
  protected JPanel createTitleGUI() {
    JPanel titlePanel = new JPanel(true);
    titlePanel.setLayout(new FlowLayout());
    titlePanel.setBackground(Color.WHITE);

    JLabel label = new JLabel(monthNames[month] + " " + year);
    label.setForeground(SystemColor.activeCaption);
    titlePanel.add(label, BorderLayout.CENTER);
    return titlePanel;
  }

  protected JPanel createDaysGUI() {
    JPanel dayPanel = new JPanel(true);
    dayPanel.setLayout(new GridLayout(0, dayNames.length));

    Calendar today = Calendar.getInstance();
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.MONTH, month);
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.DAY_OF_MONTH, 1);

    Calendar iterator = (Calendar) calendar.clone();
    iterator.add(Calendar.DAY_OF_MONTH,
        -(iterator.get(Calendar.DAY_OF_WEEK) - 1));

    Calendar maximum = (Calendar) calendar.clone();
    maximum.add(Calendar.MONTH, +1);

    for (int i = 0; i < dayNames.length; i++) {
      JPanel dPanel = new JPanel(true);
      dPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      JLabel dLabel = new JLabel(dayNames[i]);
      dPanel.add(dLabel);
      dayPanel.add(dPanel);
    }

    int count = 0;
    int limit = dayNames.length * 6;

    while (iterator.getTimeInMillis() < maximum.getTimeInMillis()) {
      int lMonth = iterator.get(Calendar.MONTH);
      int lYear = iterator.get(Calendar.YEAR);

      JPanel dPanel = new JPanel(true);
      dPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      JLabel dayLabel = new JLabel();

      if ((lMonth == month) && (lYear == year)) {
        int lDay = iterator.get(Calendar.DAY_OF_MONTH);
        dayLabel.setText(Integer.toString(lDay));
      }
      dPanel.add(dayLabel);
      dayPanel.add(dPanel);
      iterator.add(Calendar.DAY_OF_YEAR, +1);
      count++;
    }

    for (int i = count; i < limit; i++) {
      JPanel dPanel = new JPanel(true);
      dPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

      dPanel.add(new JLabel());
      dayPanel.add(dPanel);
    }
    return dayPanel;
  }

}
