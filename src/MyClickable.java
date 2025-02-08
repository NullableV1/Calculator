import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface MyClickable extends ActionListener{
    @Override
    void actionPerformed(ActionEvent e);
}
