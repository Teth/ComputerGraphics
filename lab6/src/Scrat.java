import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.*;
import javax.swing.*;
import javax.vecmath.Color3f;
import javax.vecmath.Color4f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;
import java.awt.*;
import java.util.Enumeration;
import java.util.Hashtable;

public class Scrat extends JFrame
{
    //The canvas to be drawn upon.
    public Canvas3D myCanvas3D;
    public Scrat() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myCanvas3D = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
        SimpleUniverse simpUniv = new SimpleUniverse(myCanvas3D);
        simpUniv.getViewingPlatform().setNominalViewingTransform();
        createSceneGraph(simpUniv);
        addLight(simpUniv);
        OrbitBehavior ob = new OrbitBehavior(myCanvas3D);
        ob.setSchedulingBounds(new BoundingSphere(new Point3d(0.0, 0.0, 0.0), Double.MAX_VALUE));
        simpUniv.getViewingPlatform().setViewPlatformBehavior(ob);
        setTitle("Lab6");
        setSize(700, 700);
        getContentPane().add("Center", myCanvas3D);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        Scrat scrat = new Scrat();
    }
    public void createSceneGraph(SimpleUniverse su)
    {
        ObjectFile f = new ObjectFile(ObjectFile.RESIZE);
        Scene ScratScene = null;
        try
        {
            ScratScene = f.load("models/scrat.obj");
        }
        catch (Exception e)
        {
            System.out.println("File loading failed:" + e);
        }

        Transform3D scaling = new Transform3D();
        scaling.setScale(1.0/6);
        Transform3D tfRoach = new Transform3D();
        tfRoach.rotY(Math.PI/6);
        tfRoach.mul(scaling);
        TransformGroup tgRoach = new TransformGroup(tfRoach);
        TransformGroup sceneGroup = new TransformGroup();


        Hashtable roachNamedObjects = ScratScene.getNamedObjects();
        Enumeration enumer = roachNamedObjects.keys();
        String name;
        while (enumer.hasMoreElements())
        {
            name = (String) enumer.nextElement();
            System.out.println("Name: "+name);
        }

        Appearance lightApp = new Appearance();
        setToMyDefaultAppearance(lightApp,new Color3f(Color.GREEN));


        TextureLoader loader = new TextureLoader("sources/furr.jpg", myCanvas3D);
        Texture texture = loader.getTexture();
        texture.setBoundaryModeS(Texture.ALPHA);
        texture.setBoundaryModeT(Texture.WRAP);
        texture.setBoundaryColor(new Color4f(1.0f, 0.0f, 1.0f, 5.0f));

        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.COMBINE);

        Appearance textureAP = new Appearance();

        textureAP.setTexture(texture);
        textureAP.setTextureAttributes(texAttr);

        Shape3D nose = (Shape3D) roachNamedObjects.get("nose");
        nose.setAppearance(lightApp);
        nose.setAppearance(textureAP);
        Shape3D nut = (Shape3D) roachNamedObjects.get("nut");
        nut.setAppearance(lightApp);
        nut.setAppearance(textureAP);
        Shape3D objsphere12 = (Shape3D) roachNamedObjects.get("objsphere12");
        objsphere12.setAppearance(lightApp);
        objsphere12.setAppearance(textureAP);
        Shape3D objobject07 = (Shape3D) roachNamedObjects.get("objobject07");
        objobject07.setAppearance(lightApp);
        objobject07.setAppearance(textureAP);
        Shape3D objsphere09 = (Shape3D) roachNamedObjects.get("objsphere09");
        objsphere09.setAppearance(lightApp);
        objsphere09.setAppearance(textureAP);
        Shape3D left_eye = (Shape3D) roachNamedObjects.get("left_eye");
        left_eye.setAppearance(lightApp);
        left_eye.setAppearance(textureAP);
        Shape3D objobject06 = (Shape3D) roachNamedObjects.get("objobject06");
        objobject06.setAppearance(lightApp);
        objobject06.setAppearance(textureAP);
        Shape3D objobject05 = (Shape3D) roachNamedObjects.get("objobject05");
        objobject05.setAppearance(lightApp);
        objobject05.setAppearance(textureAP);
        Shape3D left_hand = (Shape3D) roachNamedObjects.get("left_hand");
        left_hand.setAppearance(lightApp);
        left_hand.setAppearance(textureAP);
        Shape3D left_eye1 = (Shape3D) roachNamedObjects.get("left_eye1");
        left_eye1.setAppearance(lightApp);
        left_eye1.setAppearance(textureAP);
        Shape3D tale = (Shape3D) roachNamedObjects.get("tale");
        tale.setAppearance(lightApp);
        tale.setAppearance(textureAP);
        Shape3D right_hand = (Shape3D) roachNamedObjects.get("right_hand");
        right_hand.setAppearance(lightApp);
        right_hand.setAppearance(textureAP);
        Shape3D right_eye = (Shape3D) roachNamedObjects.get("right_eye");
        right_eye.setAppearance(lightApp);
        right_eye.setAppearance(textureAP);
        Shape3D body = (Shape3D) roachNamedObjects.get("body");
        body.setAppearance(lightApp);
        body.setAppearance(textureAP);


        TransformGroup scrat = new TransformGroup();
        scrat.addChild(body.cloneTree());

        TransformGroup nosetr = new TransformGroup();
        TransformGroup nuttr = new TransformGroup();
        TransformGroup objobject07tr = new TransformGroup();
        TransformGroup objsphere12tr = new TransformGroup();
        TransformGroup objsphere09tr = new TransformGroup();
        TransformGroup objobject06tr = new TransformGroup();
        TransformGroup objobject05tr = new TransformGroup();
        TransformGroup left_handtr = new TransformGroup();
        TransformGroup left_eyetr = new TransformGroup();
        TransformGroup taletr = new TransformGroup();
        TransformGroup right_handtr = new TransformGroup();
        TransformGroup right_eyetr = new TransformGroup();

        nosetr.addChild(nose.cloneTree());
        nuttr.addChild(nut.cloneTree());
        objsphere12tr.addChild(objsphere12.cloneTree());
        objsphere09tr.addChild(objsphere09.cloneTree());
        objobject07tr.addChild(objobject07.cloneTree());
        left_eyetr.addChild(left_eye.cloneTree());
        objobject06tr.addChild(objobject06.cloneTree());
        right_eyetr.addChild(right_eye.cloneTree());
        objobject05tr.addChild(objobject05.cloneTree());
        taletr.addChild(tale.cloneTree());
        left_handtr.addChild(left_hand.cloneTree());
        right_handtr.addChild(right_hand.cloneTree());

        BoundingSphere bounds = new BoundingSphere(new Point3d(120.0,250.0,100.0),Double.MAX_VALUE);
        BranchGroup theScene = new BranchGroup();
        Transform3D tCrawl = new Transform3D();
        Transform3D tCrawl1 = new Transform3D();
        tCrawl.rotY(-90D);
        tCrawl1.rotX(-90D);
        long crawlTime = 10000;
        Alpha crawlAlpha = new Alpha(1,
                Alpha.INCREASING_ENABLE,
                0,
                0, crawlTime,0,0,0,0,0);
        float crawlDistance = 3.0f;
        PositionInterpolator posICrawl = new PositionInterpolator(crawlAlpha,
                sceneGroup,tCrawl, -9.0f, crawlDistance);

        long crawlTime1 = 30000;
        Alpha crawlAlpha1 = new Alpha(1,
                Alpha.INCREASING_ENABLE,
                3000,
                0, crawlTime1,0,0,0,0,0);
        float crawlDistance1 = 15.0f;
        PositionInterpolator posICrawl1 = new PositionInterpolator(crawlAlpha1,
                sceneGroup,tCrawl1, -9.0f, crawlDistance1);

        Transform3D RightHandRotationAxis = new Transform3D();
        RightHandRotationAxis.rotZ(Math.PI / 3);
        int timeStart = 400;
        int timeRotationHour = 400;
        Alpha RightHandRotationAlpha = new Alpha(-1, Alpha.INCREASING_ENABLE | Alpha.DECREASING_ENABLE, timeStart, 0,
                timeRotationHour, 0, 0, timeRotationHour, 0, 0);
        RotationInterpolator RightHandRotation = new RotationInterpolator(RightHandRotationAlpha, right_handtr,
                RightHandRotationAxis, (float) Math.PI / 4, 0.0f);

        BoundingSphere bounds_rhand = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), Double.MAX_VALUE);
        RightHandRotation.setSchedulingBounds(bounds_rhand);
        right_handtr.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        right_handtr.addChild(RightHandRotation);

        Transform3D NutTailRotationAxis = new Transform3D();
        NutTailRotationAxis.rotZ(Math.PI / 3);
        Alpha NutTailRotationAlpha = new Alpha(-1, Alpha.INCREASING_ENABLE | Alpha.DECREASING_ENABLE, 0, 0,
                timeRotationHour, 0, 0, timeRotationHour, 0, 0);
        RotationInterpolator TailRotation = new RotationInterpolator(NutTailRotationAlpha, taletr,
                RightHandRotationAxis, (float) Math.PI / 8, 0.0f);
        RotationInterpolator NutRotation = new RotationInterpolator(NutTailRotationAlpha, nuttr,
                RightHandRotationAxis, (float) Math.PI / 8, 0.0f);
        taletr.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        taletr.addChild(TailRotation);
        nuttr.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        nuttr.addChild(NutRotation);


        Transform3D LeftHandRotationAxis = new Transform3D();
        LeftHandRotationAxis.rotZ(Math.PI / 3);
        Alpha rightLegRotationAlpha = new Alpha(-1, Alpha.INCREASING_ENABLE | Alpha.DECREASING_ENABLE, 0, 0,
                timeRotationHour, 0, 0, timeRotationHour, 0, 0);
        RotationInterpolator LeftHandRotation = new RotationInterpolator(rightLegRotationAlpha, left_handtr,
                LeftHandRotationAxis, (float) Math.PI / 4, 0.0f);
        LeftHandRotation.setSchedulingBounds(bounds_rhand);
        left_handtr.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        left_handtr.addChild(LeftHandRotation);

        BoundingSphere bs = new BoundingSphere(new Point3d(0.0,0.0,0.0),Double.MAX_VALUE);
        posICrawl.setSchedulingBounds(bs);
        posICrawl1.setSchedulingBounds(bs);
        sceneGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        sceneGroup.addChild(posICrawl);

        Alpha upRamp = new Alpha();

        upRamp.setIncreasingAlphaDuration(800);
        upRamp.setLoopCount(-1);

        left_handtr.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        right_handtr.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        nosetr.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objobject07tr.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objsphere12tr.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objobject06tr.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objsphere09tr.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objobject05tr.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        left_eyetr.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        taletr.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        right_eyetr.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);


        scrat.addChild(left_handtr);
        scrat.addChild(right_handtr);
        scrat.addChild(nosetr);
        sceneGroup.addChild(nuttr);
        scrat.addChild(objobject07tr);
        scrat.addChild(objsphere12tr);
        scrat.addChild(objobject06tr);
        scrat.addChild(objsphere09tr);
        scrat.addChild(objobject05tr);
        scrat.addChild(left_eyetr);
        scrat.addChild(taletr);
        scrat.addChild(right_eyetr);
        sceneGroup.addChild(scrat);

        tgRoach.addChild(sceneGroup);
        theScene.addChild(tgRoach);
        TextureLoader t = new TextureLoader("sources/stock-forest.jpg", myCanvas3D);
        Background bg = new Background(t.getImage());
        bg.setApplicationBounds(bounds);
        theScene.addChild(bg);
        theScene.compile();
        su.addBranchGraph(theScene);
    }

    public static void setToMyDefaultAppearance(Appearance app, Color3f col)
    {
        app.setMaterial(new Material(col,col,col,col,150.0f));
    }

    public void addLight(SimpleUniverse su)
    {
        BranchGroup bgLight = new BranchGroup();
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);
        Color3f lightColour1 = new Color3f(0.5f,1.0f,1.0f);
        Vector3f lightDir1 = new Vector3f(-1.0f,0.0f,-0.5f);
        DirectionalLight light1 = new DirectionalLight(lightColour1, lightDir1);
        light1.setInfluencingBounds(bounds);
        bgLight.addChild(light1);
        su.addBranchGraph(bgLight);
    }
}
