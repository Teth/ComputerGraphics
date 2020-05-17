import com.sun.j3d.utils.universe.*;

import java.awt.Color;
import javax.media.j3d.*;
import javax.media.j3d.Material;
import javax.vecmath.*;
import javax.media.j3d.Background;

import com.sun.j3d.loaders.*;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.loaders.lw3d.Lw3dLoader;
import com.sun.j3d.utils.image.TextureLoader;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import javax.swing.JFrame;

public class FirstMainClass extends JFrame {
    static SimpleUniverse universe;
    static Scene scene;
    static Map<String, Shape3D> nameMap;
    static BranchGroup root;
    static Canvas3D canvas;
    
    static TransformGroup wholeTank;
    static Transform3D transform3D;
    
    public FirstMainClass () throws IOException{
        configureWindow();
        configureCanvas();
        configureUniverse();
        addModelToUniverse();
        setTankElementsList();
        addAppearance();
        addImageBackground();
        addLightToUniverse();
        addOtherLight();
        ChangeViewAngle();
        root.compile();
        universe.addBranchGraph(root);
    }
    
    private void configureWindow()  {
        setTitle("Tank Animation");
        setSize(760,640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void configureCanvas(){
        canvas=new Canvas3D(SimpleUniverse.getPreferredConfiguration());
        canvas.setDoubleBufferEnable(true);
        getContentPane().add(canvas,BorderLayout.CENTER);
    }
    
    private void configureUniverse(){
        root= new BranchGroup();
        universe= new SimpleUniverse(canvas);
        universe.getViewingPlatform().setNominalViewingTransform();
    }
    
    private void addModelToUniverse() throws IOException{
        scene = getSceneFromFile("sources\\t90.obj");
        root=scene.getSceneGroup();
    }
    
    private void addLightToUniverse(){
        Bounds bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),100.0);
        Color3f color = new Color3f(65/255f, 30/255f, 25/255f);
        Vector3f lightdirection = new Vector3f(-1f,-1f,-1f);
        DirectionalLight dirlight = new DirectionalLight(color,lightdirection);
        dirlight.setInfluencingBounds(bounds);
        root.addChild(dirlight);
    }
    
    private void printModelElementsList(Map<String,Shape3D> nameMap){
        for (String name : nameMap.keySet()) {
            System.out.printf("Name: %s\n", name);}
    }
    
    private void setTankElementsList() {
        nameMap=scene.getNamedObjects();
        //Print elements of your model:
        printModelElementsList(nameMap);
        
        wholeTank = new TransformGroup();
        transform3D = new Transform3D();
        transform3D.setScale(new Vector3d(0.5,0.5,0.5));
        wholeTank.setTransform(transform3D);
        root.removeChild(nameMap.get("drawcall_02"));
        root.removeChild(nameMap.get("drawcall_1251"));
        root.removeChild(nameMap.get("drawcall_01"));
        root.removeChild(nameMap.get("drawcall_1245"));
        root.removeChild(nameMap.get("drawcall_1244"));
        root.removeChild(nameMap.get("drawcall_1309"));
        root.removeChild(nameMap.get("drawcall_1311"));
        root.removeChild(nameMap.get("drawcall_1308"));
        root.removeChild(nameMap.get("drawcall_1310"));
        root.removeChild(nameMap.get("drawcall_1306"));
        root.removeChild(nameMap.get("drawcall_1305"));
        root.removeChild(nameMap.get("drawcall_1304"));
        root.removeChild(nameMap.get("drawcall_1303"));
        root.removeChild(nameMap.get("drawcall_1301"));
        root.removeChild(nameMap.get("drawcall_1252"));

        wholeTank.addChild(nameMap.get("drawcall_02"));
        wholeTank.addChild(nameMap.get("drawcall_1251"));
        wholeTank.addChild(nameMap.get("drawcall_01"));
        wholeTank.addChild(nameMap.get("drawcall_1245"));
        wholeTank.addChild(nameMap.get("drawcall_1244"));
        wholeTank.addChild(nameMap.get("drawcall_1309"));
        wholeTank.addChild(nameMap.get("drawcall_1311"));
        wholeTank.addChild(nameMap.get("drawcall_1308"));
        wholeTank.addChild(nameMap.get("drawcall_1310"));
        wholeTank.addChild(nameMap.get("drawcall_1306"));
        wholeTank.addChild(nameMap.get("drawcall_1305"));
        wholeTank.addChild(nameMap.get("drawcall_1304"));
        wholeTank.addChild(nameMap.get("drawcall_1303"));
        wholeTank.addChild(nameMap.get("drawcall_1301"));
        wholeTank.addChild(nameMap.get("drawcall_1252"));
        wholeTank.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        root.addChild(wholeTank);
    }
    
    Texture getTexture(String path) {
        TextureLoader textureLoader = new TextureLoader(path,"RGP", new Container());
        Texture texture = textureLoader.getTexture();
        texture.setBoundaryModeS(Texture.WRAP);
        texture.setBoundaryModeT(Texture.WRAP);
        texture.setBoundaryColor( new Color4f( Color.BLUE ) );
        return texture;
    }             
    
    Material getMaterial() {
        Material material = new Material();
        material.setAmbientColor (new Color3f(Color.WHITE));
        material.setDiffuseColor ( new Color3f(Color.CYAN) );
        material.setSpecularColor( new Color3f(Color.WHITE));
        material.setShininess( 0.5f );
        material.setLightingEnable(true);
        return material;
    }
    
    private void addAppearance(){
        Appearance TankAppearance = new Appearance();
        TankAppearance.setTexture(getTexture("sources\\8eca739b.jpg"));
        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.COMBINE);
        TankAppearance.setTextureAttributes(texAttr);
        TankAppearance.setMaterial(getMaterial());
        Shape3D t1 = nameMap.get("drawcall_1251");
        Shape3D t2 = nameMap.get("drawcall_02");
        Shape3D t3 = nameMap.get("drawcall_01");
        Shape3D t4 = nameMap.get("drawcall_1245");
        Shape3D t5 = nameMap.get("drawcall_1244");
        Shape3D t6 = nameMap.get("drawcall_1309");
        Shape3D t7 = nameMap.get("drawcall_1311");
        Shape3D t8 = nameMap.get("drawcall_1308");
        Shape3D t9 = nameMap.get("drawcall_1310");
        Shape3D t10 = nameMap.get("drawcall_1306");
        Shape3D t11 = nameMap.get("drawcall_1305");
        Shape3D t12 = nameMap.get("drawcall_1304");
        Shape3D t13 = nameMap.get("drawcall_1303");
        Shape3D t14 = nameMap.get("drawcall_1301");
        Shape3D t15 = nameMap.get("drawcall_1252");
        t1.setAppearance(TankAppearance);
        t2.setAppearance(TankAppearance);
        t3.setAppearance(TankAppearance);
        t4.setAppearance(TankAppearance);
        t5.setAppearance(TankAppearance);
        t6.setAppearance(TankAppearance);
        t7.setAppearance(TankAppearance);
        t8.setAppearance(TankAppearance);
        t9.setAppearance(TankAppearance);
        t10.setAppearance(TankAppearance);
        t11.setAppearance(TankAppearance);
        t12.setAppearance(TankAppearance);
        t13.setAppearance(TankAppearance);
        t14.setAppearance(TankAppearance);
        t15.setAppearance(TankAppearance);
    }
    
    private void addColorBackground(){
        Background background = new Background(new Color3f(Color.CYAN));
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),100.0);
        background.setApplicationBounds(bounds);      
        root.addChild(background); 
    }
    
    private void addImageBackground(){
        TextureLoader t = new TextureLoader("sources\\l21.jpg", canvas);
        Background background = new Background(t.getImage());
        background.setImageScaleMode(Background.SCALE_FIT_ALL);
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),100.0);
        background.setApplicationBounds(bounds);
        root.addChild(background);
    }
    
    private void ChangeViewAngle(){
        ViewingPlatform vp = universe.getViewingPlatform();
        TransformGroup vpGroup = vp.getMultiTransformGroup().getTransformGroup(0);
        Transform3D vpTranslation = new Transform3D();
        Vector3f translationVector = new Vector3f(0.0F, -1.2F, 6F);
        vpTranslation.setTranslation(translationVector);
        vpGroup.setTransform(vpTranslation);
    }
    
    private void addOtherLight(){
        Color3f directionalLightColor = new Color3f(Color.BLACK);
        Color3f ambientLightColor = new Color3f(Color.WHITE);
        Vector3f lightDirection = new Vector3f(-1F, -1F, -1F);

        AmbientLight ambientLight = new AmbientLight(ambientLightColor);
        DirectionalLight directionalLight = new DirectionalLight(directionalLightColor, lightDirection);

        Bounds influenceRegion = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),100.0);

        ambientLight.setInfluencingBounds(influenceRegion);
        directionalLight.setInfluencingBounds(influenceRegion); 
        root.addChild(ambientLight);
        root.addChild(directionalLight);
    }
   
    public static Scene getSceneFromFile(String location) throws IOException {
        ObjectFile file = new ObjectFile(ObjectFile.RESIZE);
        file.setFlags (ObjectFile.RESIZE | ObjectFile.TRIANGULATE | ObjectFile.STRIPIFY);
        return file.load(new FileReader(location));
    }
    
    //Not always works
    public static Scene getSceneFromLwoFile(String location) throws IOException {
        Lw3dLoader loader = new Lw3dLoader();
        return loader.load(new FileReader(location));
     }
    
    public static void main(String[]args){
        try {
            FirstMainClass window = new FirstMainClass();
            AnimationTank TankMovement = new AnimationTank(wholeTank, transform3D, window);
            window.addKeyListener(TankMovement);
            window.setVisible(true);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
