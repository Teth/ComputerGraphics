import javax.media.j3d.*; // for transform
import javax.vecmath.Color3f;
import java.awt.Color;

public class Utils {
    public static Appearance getBodyAppearence() {
        Appearance ap = new Appearance();

        Color3f emissive = new Color3f(new Color(30,50,30));
        Color3f ambient = new Color3f(Color.GREEN);
        Color3f diffuse = new Color3f(Color.GREEN);
        Color3f specular = new Color3f(new Color(30,50,30));
        // ambient, emissive, diffuse, specular, 1.0f
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));

        return ap;
    }

    public static Appearance getDiskAppearence() {
        Appearance ap = new Appearance();

        Color3f emissive = new Color3f(new Color(0,0, 0));
        Color3f ambient = new Color3f(Color.GRAY);
        Color3f diffuse = new Color3f(new Color(220,220, 255));
        Color3f specular = new Color3f(new Color(220,220, 255));
        // ambient, emissive, diffuse, specular, 1.0f
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));

        return ap;
    }

    public static Appearance getRadiatorAppearence() {
        Appearance ap = new Appearance();

        Color3f emissive = new Color3f(new Color(0,0, 0));
        Color3f ambient = new Color3f(Color.BLACK);
        Color3f diffuse = new Color3f(new Color(10,70,10));
        Color3f specular = new Color3f(Color.GRAY);
        // ambient, emissive, diffuse, specular, 1.0f
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));

        return ap;
    }

    public static Appearance getWheelAppearence() {
        Appearance ap = new Appearance();

        Color3f emissive = new Color3f(new Color(0,0, 0));
        Color3f ambient = new Color3f(Color.BLACK);
        Color3f diffuse = new Color3f(Color.BLACK);
        Color3f specular = new Color3f(Color.BLACK);
        // ambient, emissive, diffuse, specular, 1.0f
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));

        return ap;
    }

    public static Appearance getGlassAppearence() {
        Appearance ap = new Appearance();

        Color3f emissive = new Color3f(new Color(0,60, 0));
        Color3f ambient = new Color3f(Color.BLACK);
        Color3f diffuse = new Color3f(Color.LIGHT_GRAY);
        Color3f specular = new Color3f(new Color(200,250,200));
        // ambient, emissive, diffuse, specular, 1.0f
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));

        return ap;
    }
}
