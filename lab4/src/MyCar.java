import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.universe.SimpleUniverse;


import javax.media.j3d.*;
import javax.swing.*;
import javax.vecmath.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCar implements ActionListener {
    private TransformGroup carTransformGroup;
    private TransformGroup viewingTransformGroup;
    private Transform3D carTransform3D = new Transform3D();
    private Transform3D viewingTransform = new Transform3D();
    private float angle = 0;


    public static void main(String[] args) {
        new MyCar();
    }

    private MyCar() {
        Timer timer = new Timer(50, this);
        SimpleUniverse universe = new SimpleUniverse();

        viewingTransformGroup = universe.getViewingPlatform().getViewPlatformTransform();
        universe.addBranchGraph(createSceneGraph());
        timer.start();
    }

    private BranchGroup createSceneGraph() {
        BranchGroup objRoot = new BranchGroup();
        carTransformGroup = new TransformGroup();
        carTransformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        buildCar();

        objRoot.addChild(carTransformGroup);
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, -0.8, 0.0),100.0);
        Color3f light1Color = new Color3f(1f, 0.5f, 1f);
        Vector3f light1Direction = new Vector3f(4.0f, -7.0f, 12.0f);
        DirectionalLight light1 = new DirectionalLight(light1Color, light1Direction);
        light1.setInfluencingBounds(bounds);
        objRoot.addChild(light1);

        // встановлюємо навколишнє освітлення
        Color3f ambientColor = new Color3f(1.0f, 1.0f, 1.0f);
        AmbientLight ambientLightNode = new AmbientLight(ambientColor);
        ambientLightNode.setInfluencingBounds(bounds);
        objRoot.addChild(ambientLightNode);

        return objRoot;
    }


    private TransformGroup buildTG() {
        return buildTG(new Vector3f(), new Transform3D());
    }

    private TransformGroup buildTG(Vector3f translation) {
        return buildTG(translation, new Transform3D());
    }

    private TransformGroup buildTG(Vector3f translation, Transform3D rotation){
        Transform3D transform = new Transform3D();
        TransformGroup transformG = new TransformGroup();
        transform.setTranslation(translation);
        transform.mul(rotation, transform);
        transformG.setTransform(transform);
        return transformG;
    }

    private void buildCar() {

        //body
        Box body1 = new Box(4, 3, 3, Utils.getBodyAppearence());
        TransformGroup body1TG = buildTG();
        body1TG.addChild(body1);

        Box body2 = new Box(2, 3, 1.5f, Utils.getBodyAppearence());
        TransformGroup body2TG = buildTG(new Vector3f(6, 0,-1.5f ));
        body2TG.addChild(body2);
        body1TG.addChild(body2TG);

        Box body3 = new Box(2, 3, 1.5f, Utils.getBodyAppearence());
        TransformGroup body3TG = buildTG(new Vector3f(-4.5f, 0,-1.5f ));
        body3TG.addChild(body3);
        body1TG.addChild(body3TG);

        Box glass = new Box(2f, 2.6f, 1.3f, Utils.getGlassAppearence());
        TransformGroup glassTG = buildTG(new Vector3f(2.2f, 0, 1.3f));
        glassTG.addChild(glass);
        body1TG.addChild(glassTG);

        Box glassback = new Box(2f, 2.8f, 1.3f, Utils.getGlassAppearence());
        TransformGroup glassbackTG = buildTG(new Vector3f(-2.2f, 0, 1.3f));
        glassbackTG.addChild(glassback);
        body1TG.addChild(glassbackTG);

        Cylinder wheel1 = new Cylinder(1.5f, 0.8f, Utils.getWheelAppearence());
        TransformGroup wheel1TG = buildTG(new Vector3f(-3.5f, 3, -3));
        wheel1TG.addChild(wheel1);
        body1TG.addChild(wheel1TG);

        Cylinder wheel1_disk = new Cylinder(1.3f, 0.9f, Utils.getDiskAppearence());
        TransformGroup wheel1diskTG = buildTG(new Vector3f(-3.5f, 3f, -3f));
        wheel1diskTG.addChild(wheel1_disk);
        body1TG.addChild(wheel1diskTG);

        Cylinder wheel2 = new Cylinder(1.5f, 0.8f, Utils.getWheelAppearence());
        TransformGroup wheel2TG = buildTG(new Vector3f(-3.5f, -3.2f, -3));
        wheel2TG.addChild(wheel2);
        body1TG.addChild(wheel2TG);

        Cylinder wheel2_disk = new Cylinder(1.3f, 0.9f, Utils.getDiskAppearence());
        TransformGroup wheel2diskTG = buildTG(new Vector3f(-3.5f, -3.2f, -3));
        wheel2diskTG.addChild(wheel2_disk);
        body1TG.addChild(wheel2diskTG);

        Cylinder wheel3 = new Cylinder(1.5f, 0.8f, Utils.getWheelAppearence());
        TransformGroup wheel3TG = buildTG(new Vector3f(5, 3, -3));
        wheel3TG.addChild(wheel3);
        body1TG.addChild(wheel3TG);

        Cylinder wheel3_disk = new Cylinder(1.3f, 0.9f, Utils.getDiskAppearence());
        TransformGroup wheel3diskTG = buildTG(new Vector3f(5, 3, -3));
        wheel3diskTG.addChild(wheel3_disk);
        body1TG.addChild(wheel3diskTG);

        Cylinder wheel4 = new Cylinder(1.5f, 0.8f, Utils.getWheelAppearence());
        TransformGroup wheel4TG = buildTG(new Vector3f(5, -3, -3));
        wheel4TG.addChild(wheel4);
        body1TG.addChild(wheel4TG);

        Cylinder wheel4_disk = new Cylinder(1.3f, 0.9f, Utils.getDiskAppearence());
        TransformGroup wheel4diskTG = buildTG(new Vector3f(5, -3, -3));
        wheel4diskTG.addChild(wheel4_disk);
        body1TG.addChild(wheel4diskTG);

        Box radiator1 = new Box(2.1f, 0.3f, 0.9f, Utils.getRadiatorAppearence());
        TransformGroup radiator1TG = buildTG(new Vector3f(6.1f, -1.6f, -1));
        radiator1TG.addChild(radiator1);
        body1TG.addChild(radiator1TG);

        Box radiator2 = new Box(2.1f, 0.3f, 0.9f, Utils.getRadiatorAppearence());
        TransformGroup radiator2TG = buildTG(new Vector3f(6.1f, -0.5f, -1));
        radiator2TG.addChild(radiator2);
        body1TG.addChild(radiator2TG);

        Box radiator3 = new Box(2.1f, 0.3f, 0.9f, Utils.getRadiatorAppearence());
        TransformGroup radiator3TG = buildTG(new Vector3f(6.1f, 0.5f, -1));
        radiator3TG.addChild(radiator3);
        body1TG.addChild(radiator3TG);

        Box radiator4 = new Box(2.1f, 0.3f, 0.9f, Utils.getRadiatorAppearence());
        TransformGroup radiator4TG = buildTG(new Vector3f(6.1f, 1.6f, -1));
        radiator4TG.addChild(radiator4);
        body1TG.addChild(radiator4TG);

        Box windows1 = new Box(1.6f, 3.1f, 1.3f, Utils.getGlassAppearence());
        TransformGroup windows1TG = buildTG(new Vector3f(1.8f, 0, 1.3f));
        windows1TG.addChild(windows1);
        body1TG.addChild(windows1TG);

        Box windows2 = new Box(1.6f, 3.1f, 1.3f, Utils.getGlassAppearence());
        TransformGroup windows2TG = buildTG(new Vector3f(-1.8f, 0, 1.3f));
        windows2TG.addChild(windows2);
        body1TG.addChild(windows2TG);

        carTransformGroup.addChild(body1TG);

    }

    // ActionListener interface
    @Override
    public void actionPerformed(ActionEvent e) {
        float delta = 0.03f;

        // rotation of the castle
        carTransform3D.rotZ(angle);
        carTransformGroup.setTransform(carTransform3D);
        angle += delta;

        Point3d eye = new Point3d(20.0f, 0f, 6.0f); // spectator's eye
        Point3d center = new Point3d(0f, .0f ,1.0f); // sight target
        Vector3d up = new Vector3d(.0f, .0f, 1.0f);; // the camera frustum
        viewingTransform.lookAt(eye, center, up);
        viewingTransform.invert();
        viewingTransformGroup.setTransform(viewingTransform);
    }
}
