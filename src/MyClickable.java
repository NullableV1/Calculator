import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface MyClickable extends ActionListener {
    @Override
    public void actionPerformed(ActionEvent e);
}
