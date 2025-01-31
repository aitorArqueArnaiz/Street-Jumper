package particleSystem;

import org.andengine.engine.Engine;
import org.andengine.entity.particle.ParticleSystem;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;

import android.content.Context;

public interface ParticleSystemFactory
{
        public void load(Context context, Engine engine);
        
        public ParticleSystem<Sprite> build(Engine engine, float fontX, float fontY);
        
        public ParticleSystem<Sprite> build(Engine engine, float fontX, float fontY, ITextureRegion texture);
        
        public String getTitle();
}
