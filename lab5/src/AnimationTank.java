import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.media.j3d.*;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.vecmath.*;

public class AnimationTank implements ActionListener, KeyListener {
    private Button go;
    private TransformGroup tankT90;
    private Transform3D translateTransform;
    private Transform3D rotateTransformX;
    private Transform3D rotateTransformY;
    private Transform3D rotateTransformZ;

    private JFrame mainFrame;


    private float sign=1.0f;
    private float zoom=2.3f;
    private float xloc=0.0f;
    private float yloc=-2.3f;
    private float zloc=-2.0f;
    private Timer timer;
    int side = 0;

    public AnimationTank(TransformGroup wholeTank, Transform3D trans, JFrame frame){
        go = new Button("Go");
        this.tankT90=wholeTank;
        this.translateTransform=trans;
        this.mainFrame=frame;

        rotateTransformX= new Transform3D();
        rotateTransformY= new Transform3D();
        rotateTransformZ= new Transform3D();
        rotateTransformX.rotX(3*Math.PI/2);
        rotateTransformZ.rotZ(Math.PI/2);
        translateTransform.mul(rotateTransformY);
        translateTransform.mul(rotateTransformX);

        FirstMainClass.canvas.addKeyListener(this);
        timer = new Timer(100, this);

        Panel p =new Panel();
        p.add(go);
        mainFrame.add("North",p);
        go.addActionListener(this);
        go.addKeyListener(this);
    }

    private void initialTankState(){
        xloc=0.0f;
        yloc=0.0f;
        zloc=0.0f;
        zoom=1.0f;
        sign=1.0f;
        if(timer.isRunning()){timer.stop();}
        go.setLabel("Go");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // start timer when button is pressed
        if (e.getSource()==go){
            if (!timer.isRunning()) {
                timer.start();
                go.setLabel("Stop");
            }
            else {
                timer.stop();
                go.setLabel("Go");
            }
        }
        else {
            Move();
            translateTransform.setScale(new Vector3d(zoom,zoom,zoom));
            translateTransform.setTranslation(new Vector3f(xloc,yloc,zloc));
            tankT90.setTransform(translateTransform);
        }
    }
    private void Move(){
        xloc += 0.1 * sign;
        if (Math.abs(xloc *2) >= 8 ) {
            sign = -1.0f * sign;
            rotateTransformZ.rotZ(Math.PI);
            translateTransform.mul(rotateTransformZ);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Invoked when a key has been typed.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar()=='1') {
            rotateTransformX.rotX(Math.PI/2);
            translateTransform.mul(rotateTransformX);
        }
        if (e.getKeyChar()=='2') {
            rotateTransformY.rotY(Math.PI/2);
            translateTransform.mul(rotateTransformY);
        }
        if (e.getKeyChar()=='3') {
            rotateTransformZ.rotZ(Math.PI/2);
            translateTransform.mul(rotateTransformZ);
        }
        if (e.getKeyChar()=='0'){
            rotateTransformY.rotY(Math.PI/2.8);
            translateTransform.mul(rotateTransformY);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Invoked when a key has been released.
    }

}
