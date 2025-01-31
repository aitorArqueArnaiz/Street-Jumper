package Scene;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;
import org.andengine.util.adt.color.Color;

import ResourcesManagment.ResourcesManager;
import ResourcesManagment.SceneManager;
import ResourcesManagment.SceneManager.SceneType;

public class OptionsScene extends BaseScene implements IOnMenuItemClickListener
{
	
	private MenuScene menuChildScene;
	
	IMenuItem player1Sel = new ScaleMenuItemDecorator(new SpriteMenuItem(1, resourcesManager.player1, vbom), 1.2f, 1);
	IMenuItem player2Sel = new ScaleMenuItemDecorator(new SpriteMenuItem(2, resourcesManager.player2, vbom), 1.2f, 1);
	IMenuItem player3Sel= new ScaleMenuItemDecorator(new SpriteMenuItem(3, resourcesManager.player3, vbom), 1.2f, 1);
	IMenuItem player4Sel = new ScaleMenuItemDecorator(new SpriteMenuItem(4, resourcesManager.player4, vbom), 1.2f, 1);
	IMenuItem yesSel3;
	IMenuItem notSel3;
	IMenuItem yesSel;
	IMenuItem notSel;
	IMenuItem yesSel2;
	IMenuItem notSel2;
	
	private final int MENU_PLAYER_SEL = 0;
	private final int PLAYER1_SEL = 1;
	private final int PLAYER2_SEL = 2;
	private final int PLAYER3_SEL = 3;
	private final int PLAYER4_SEL = 4;
	
	private final int LEVEL1_SEL = 7;
	private final int LEVEL2_SEL = 8;
	private final int LEVEL3_SEL = 9;
	private final int LEVEL4_SEL = 10;
	private final int LEVEL5_SEL = 15;
	IMenuItem level1Sel;
	
	private final int AR_SEL = 5;
	private final int LEVEL_SEL = 6;
	private final int SHADER = 11;
	private final int PARTICLE = 12;
	private final int YES = 13;
	private final int NOT = 14;
	
	private void createBackground()
	 {
	     attachChild(new Sprite(400, 240, resourcesManager.options_background_region, vbom)
	     {
	         @Override
	         protected void preDraw(GLState pGLState, Camera pCamera) 
	         {
	             super.preDraw(pGLState, pCamera);
	             pGLState.enableDither();
	         }
	     });
	 }
	
	private void createMenuChildScene()
	{
		 menuChildScene = new MenuScene(camera);
	     menuChildScene.setPosition(-250, 200);
	     
	     final IMenuItem player = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_PLAYER_SEL, resourcesManager.options_player_selection, vbom), 1.2f, 1);
	     final IMenuItem arealSel = new ScaleMenuItemDecorator(new SpriteMenuItem(AR_SEL, resourcesManager.ARSel, vbom), 1.2f, 1);
	     final IMenuItem levelSelection = new ScaleMenuItemDecorator(new SpriteMenuItem(LEVEL_SEL, resourcesManager.levelLoad, vbom), 1.2f, 1);
	     level1Sel = new ScaleMenuItemDecorator(new SpriteMenuItem(LEVEL1_SEL, resourcesManager.level_1, vbom), 1, 1);
	     final IMenuItem shaderSel = new ScaleMenuItemDecorator(new SpriteMenuItem(SHADER, resourcesManager.shaderOption, vbom), 1.2f, 1);
	     final IMenuItem particleSel = new ScaleMenuItemDecorator(new SpriteMenuItem(PARTICLE, resourcesManager.particleOption, vbom), 1.2f, 1);
	     
	     
	     menuChildScene.addMenuItem(player);
	     menuChildScene.addMenuItem(arealSel);
	     menuChildScene.addMenuItem(levelSelection);
	     menuChildScene.addMenuItem(level1Sel);
	     menuChildScene.addMenuItem(shaderSel);
	     menuChildScene.addMenuItem(particleSel);
  
	     menuChildScene.buildAnimations();
	     menuChildScene.setBackgroundEnabled(false);
	     
	     player.setPosition(player.getX() + 90 , player.getY() - 325);
	     arealSel.setPosition(arealSel.getX() + 100 , arealSel.getY() - 300);
	     levelSelection.setPosition(levelSelection.getX() + 100, levelSelection.getY() - 275);
	     level1Sel.setPosition(level1Sel.getX() + 805 , level1Sel.getY() + 25);
     	 shaderSel.setPosition(shaderSel.getX() + 100 , shaderSel.getY() - 155);
     	 particleSel.setPosition(particleSel.getX() + 100 , particleSel.getY() - 135);
 
	     menuChildScene.setOnMenuItemClickListener(this);
	     setChildScene(menuChildScene);
	     
	    //Player
	    menuChildScene.clearChildScene();
 		menuChildScene.reset();
	 	if (ResourcesManager.getInstance().player_sel == 0) player1Sel = new ScaleMenuItemDecorator(new SpriteMenuItem(PLAYER1_SEL, resourcesManager.player1, vbom), 1.2f, 1);
	 	if (ResourcesManager.getInstance().player_sel == 1) player1Sel = new ScaleMenuItemDecorator(new SpriteMenuItem(PLAYER2_SEL, resourcesManager.player2, vbom), 1.2f, 1);
	 	if (ResourcesManager.getInstance().player_sel == 2) player1Sel = new ScaleMenuItemDecorator(new SpriteMenuItem(PLAYER3_SEL, resourcesManager.player3, vbom), 1.2f, 1);
	 	if (ResourcesManager.getInstance().player_sel == 3) player1Sel = new ScaleMenuItemDecorator(new SpriteMenuItem(PLAYER4_SEL, resourcesManager.player4, vbom), 1.2f, 1);
	 	menuChildScene.addMenuItem(player1Sel);
	 	player1Sel.setPosition(player1Sel.getX() + 875 , player1Sel.getY() + 200);
	 	
	 	// AR
	 	yesSel3 = new ScaleMenuItemDecorator(new SpriteMenuItem(YES, resourcesManager.yes, vbom), 1, 1);
    	notSel3 = new ScaleMenuItemDecorator(new SpriteMenuItem(NOT, resourcesManager.not, vbom), 1, 1);
	 	if (ResourcesManager.getInstance().arSel)
    	{
   	     	yesSel3.setPosition(yesSel3.getX() + 850 , yesSel3.getY() + 125);
   	     	notSel3.setPosition(notSel3.getX() + 950 , notSel3.getY() + 125);
   	     	notSel3.setColor(Color.RED);
   	     	yesSel3.setColor(Color.WHITE);
    		menuChildScene.addMenuItem(yesSel3);
    		menuChildScene.addMenuItem(notSel3);
    	}
    	else
    	{
   	     	notSel3.setPosition(notSel3.getX() + 950 , notSel3.getY() + 125);
   	     	yesSel3.setPosition(yesSel3.getX() + 850 , yesSel3.getY() + 125);
   	     	yesSel3.setColor(Color.RED);
   	     	notSel3.setColor(Color.WHITE);
    		menuChildScene.addMenuItem(notSel3);
    		menuChildScene.addMenuItem(yesSel3);
    	}
		
		//Level
		if (ResourcesManager.getInstance().levelSel == 0) level1Sel = new ScaleMenuItemDecorator(new SpriteMenuItem(LEVEL1_SEL, resourcesManager.level_1, vbom), 1, 1);
		if (ResourcesManager.getInstance().levelSel == 1) level1Sel = new ScaleMenuItemDecorator(new SpriteMenuItem(LEVEL2_SEL, resourcesManager.level_2, vbom), 1, 1);
		if (ResourcesManager.getInstance().levelSel == 2) level1Sel = new ScaleMenuItemDecorator(new SpriteMenuItem(LEVEL3_SEL, resourcesManager.level_3, vbom), 1, 1);
		if (ResourcesManager.getInstance().levelSel == 3) level1Sel = new ScaleMenuItemDecorator(new SpriteMenuItem(LEVEL4_SEL, resourcesManager.level_4, vbom), 1, 1);
		if (ResourcesManager.getInstance().levelSel == 4) level1Sel = new ScaleMenuItemDecorator(new SpriteMenuItem(LEVEL5_SEL, resourcesManager.level_5, vbom), 1, 1);
		menuChildScene.addMenuItem(level1Sel);
	    level1Sel.setPosition(level1Sel.getX() + 900 , level1Sel.getY() + 25);
	    
	    // Shader
	    yesSel = new ScaleMenuItemDecorator(new SpriteMenuItem(YES, resourcesManager.yes, vbom), 1, 1);
    	notSel = new ScaleMenuItemDecorator(new SpriteMenuItem(NOT, resourcesManager.not, vbom), 1, 1);
    	if (ResourcesManager.getInstance().activated)
    	{
   	     	yesSel.setPosition(yesSel.getX() + 850 , yesSel.getY() - 75);
   	     	notSel.setPosition(notSel.getX() + 950 , notSel.getY() - 75);
   	     	notSel.setColor(Color.RED);
   	     	yesSel.setColor(Color.WHITE);
    		menuChildScene.addMenuItem(yesSel);
    		menuChildScene.addMenuItem(notSel);
    	}
    	else
    	{
   	     	notSel.setPosition(notSel.getX() + 950 , notSel.getY() - 75);
   	     	yesSel.setPosition(yesSel.getX() + 850 , yesSel.getY() - 75);
   	     	yesSel.setColor(Color.RED);
   	     	notSel.setColor(Color.WHITE);
    		menuChildScene.addMenuItem(notSel);
    		menuChildScene.addMenuItem(yesSel);
    	}
		
		//Particles
		yesSel2 = new ScaleMenuItemDecorator(new SpriteMenuItem(YES, resourcesManager.yes, vbom), 1, 1);
    	notSel2 = new ScaleMenuItemDecorator(new SpriteMenuItem(NOT, resourcesManager.not, vbom), 1, 1);
		if (ResourcesManager.getInstance().activated2)
    	{
   	     	yesSel2.setPosition(yesSel2.getX() + 850 , yesSel2.getY() - 130);
   	     	notSel2.setPosition(notSel2.getX() + 950 , notSel2.getY() - 130);
   	     	notSel2.setColor(Color.RED);
   	     	yesSel2.setColor(Color.WHITE);
    		menuChildScene.addMenuItem(yesSel2);
    		menuChildScene.addMenuItem(notSel2);
    	}
    	else
    	{
   	     	notSel2.setPosition(notSel2.getX() + 950 , notSel2.getY() - 130);
   	     	yesSel2.setPosition(yesSel2.getX() + 850 , yesSel2.getY() - 130);
   	     	yesSel2.setColor(Color.RED);
   	     	notSel2.setColor(Color.WHITE);
    		menuChildScene.addMenuItem(notSel2);
    		menuChildScene.addMenuItem(yesSel2);
    	}	
	}
	
	@Override
    public void createScene()
    {
		createBackground();
		createMenuChildScene();
    }
	

	@Override
	public void onBackKeyPressed()
	{
		ResourcesManager.getInstance().unloadOptionsScreen();
		SceneManager.getInstance().loadMenuScene(engine);
		disposeScene();
		
	}

	@Override
	public SceneType getSceneType()
	{
		return SceneType.SCENE_OPTIONS;
	}

    public void disposeScene()
    {
    }

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem, float pMenuItemLocalX, float pMenuItemLocalY)
	{

		 switch(pMenuItem.getID())
	    {
		 
	        case MENU_PLAYER_SEL:

	            //Load Corresponding texture ---> player selected
	        	switch (ResourcesManager.getInstance().player_sel)
	        	{
	        	
		        	case 0:
		        		
		        		ResourcesManager.getInstance().player_sel = 1;
		        		ResourcesManager.getInstance().controlLoaded = true;
		        		resourcesManager.playerSelected = 0; 
		        		menuChildScene.clearChildScene();
		        		menuChildScene.reset();
		        		player4Sel.reset();
		       	     	player1Sel = new ScaleMenuItemDecorator(new SpriteMenuItem(PLAYER1_SEL, resourcesManager.player2, vbom), 1.2f, 1);
		       	     	menuChildScene.addMenuItem(player1Sel);
		       	     	player1Sel.setPosition(player1Sel.getX() + 875 , player1Sel.getY() + 200);
		        		break;
		        		
		        	case 1:
		        		
		        		ResourcesManager.getInstance().player_sel = 2;
		        		resourcesManager.playerSelected = 1;
		        		ResourcesManager.getInstance().controlLoaded = true; 
		        		menuChildScene.clearChildScene();
		        		menuChildScene.reset();
		        		player1Sel.reset();
		       	     	player2Sel = new ScaleMenuItemDecorator(new SpriteMenuItem(PLAYER2_SEL, resourcesManager.player3, vbom), 1.2f, 1);
		       	     	menuChildScene.addMenuItem(player2Sel);
		       	     	player2Sel.setPosition(player2Sel.getX() + 875 , player2Sel.getY() + 200);
		        		break;
		        		
		        	case 2:
		        		
		        		ResourcesManager.getInstance().player_sel = 3;
		        		resourcesManager.playerSelected = 2;
		        		ResourcesManager.getInstance().controlLoaded = true;   
		        		menuChildScene.clearChildScene();
		        		menuChildScene.reset();
		        		player2Sel.reset();
		       	     	player3Sel = new ScaleMenuItemDecorator(new SpriteMenuItem(PLAYER3_SEL, resourcesManager.player4, vbom), 1.2f, 1);
		       	     	menuChildScene.addMenuItem(player3Sel);
		       	     	player3Sel.setPosition(player3Sel.getX() + 875 , player3Sel.getY() + 200);
		        		break;
		        		
		        	case 3:
		        		
		        		ResourcesManager.getInstance().player_sel = 0;
		        		resourcesManager.playerSelected = 3;
		        		ResourcesManager.getInstance().controlLoaded = true;  
		        		menuChildScene.clearChildScene();
		        		menuChildScene.reset();
		        		player3Sel.reset();
		       	     	player4Sel = new ScaleMenuItemDecorator(new SpriteMenuItem(PLAYER4_SEL, resourcesManager.player1, vbom), 1.2f, 1);
		       	     	menuChildScene.addMenuItem(player4Sel);
		       	     	player4Sel.setPosition(player4Sel.getX() + 875 , player4Sel.getY() + 200);
		        		break;
		        		
		        	default:
		        		break;
	        	}
	        	return true;
	        	
	        case AR_SEL: 
	        	
    			ResourcesManager.getInstance().setAR(!ResourcesManager.getInstance().getAR());
    			ResourcesManager.getInstance().arSel = !ResourcesManager.getInstance().arSel;
	        	yesSel3 = new ScaleMenuItemDecorator(new SpriteMenuItem(YES, resourcesManager.yes, vbom), 1, 1);
	        	notSel3 = new ScaleMenuItemDecorator(new SpriteMenuItem(NOT, resourcesManager.not, vbom), 1, 1);
	        	if (ResourcesManager.getInstance().arSel)
	        	{
	       	     	yesSel3.setPosition(yesSel3.getX() + 850 , yesSel3.getY() + 125);
	       	     	notSel3.setPosition(notSel3.getX() + 950 , notSel3.getY() + 125);
	       	     	notSel3.setColor(Color.RED);
	       	     	yesSel3.setColor(Color.WHITE);
	        		menuChildScene.addMenuItem(yesSel3);
	        		menuChildScene.addMenuItem(notSel3);
	        	}
	        	else
	        	{
	       	     	notSel3.setPosition(notSel3.getX() + 950 , notSel3.getY() + 125);
	       	     	yesSel3.setPosition(yesSel3.getX() + 850 , yesSel3.getY() + 125);
	       	     	yesSel3.setColor(Color.RED);
	       	     	notSel3.setColor(Color.WHITE);
	        		menuChildScene.addMenuItem(notSel3);
	        		menuChildScene.addMenuItem(yesSel3);
	        	}
    			break;
	        			
	        case LEVEL_SEL:
	        	
	        	switch(ResourcesManager.getInstance().levelSel)
	        	{
	        	
		        	case 0:
		        		
		        		ResourcesManager.getInstance().levelSel = 1;
		        		final IMenuItem level1Sel = new ScaleMenuItemDecorator(new SpriteMenuItem(LEVEL1_SEL, resourcesManager.level_2, vbom), 1, 1);
		       	     	menuChildScene.addMenuItem(level1Sel);
		       	     	level1Sel.setPosition(level1Sel.getX() + 900 , level1Sel.getY() + 25);
		        		
		        		break;
		        		
		        	case 1:
		        		
		        		ResourcesManager.getInstance().levelSel = 2;
		        		final IMenuItem level2Sel = new ScaleMenuItemDecorator(new SpriteMenuItem(LEVEL2_SEL, resourcesManager.level_3, vbom), 1, 1);
		       	     	menuChildScene.addMenuItem(level2Sel);
		       	     	level2Sel.setPosition(level2Sel.getX() + 900 , level2Sel.getY() + 25);
		        		
		        		break;
		        		
		        	case 2:
		        		
		        		ResourcesManager.getInstance().levelSel = 3;
		        		final IMenuItem level3Sel = new ScaleMenuItemDecorator(new SpriteMenuItem(LEVEL3_SEL, resourcesManager.level_4, vbom), 1, 1);
		       	     	menuChildScene.addMenuItem(level3Sel);
		       	     	level3Sel.setPosition(level3Sel.getX() + 900 , level3Sel.getY() + 25);
		        		
		        		break;
		        		
		        	case 3:
		        		
		        		ResourcesManager.getInstance().levelSel = 4;
		        		final IMenuItem level4Sel = new ScaleMenuItemDecorator(new SpriteMenuItem(LEVEL4_SEL, resourcesManager.level_5, vbom), 1, 1);
		       	     	menuChildScene.addMenuItem(level4Sel);
		       	     	level4Sel.setPosition(level4Sel.getX() + 900 , level4Sel.getY() + 25);
		        		
		        		break;
		        		
		        	case 4:
		        		
		        		ResourcesManager.getInstance().levelSel = 0;
		        		final IMenuItem level5Sel = new ScaleMenuItemDecorator(new SpriteMenuItem(LEVEL5_SEL, resourcesManager.level_1, vbom), 1, 1);
		       	     	menuChildScene.addMenuItem(level5Sel);
		       	     	level5Sel.setPosition(level5Sel.getX() + 900 , level5Sel.getY() + 25);
		       	     	
		       	     	break;
		        		
		        	default: 
		        		break;
	        	
	        	}
	        	
	        	// Assign level selected to resources manager variable
	        	ResourcesManager.getInstance().setLevelComplete((ResourcesManager.getInstance().getLevelComplete() % 5) + 1);
	        	return true;
	        	
	        case SHADER:
	        	
	        	ResourcesManager.getInstance().shaderActivated = !ResourcesManager.getInstance().shaderActivated;
	        	ResourcesManager.getInstance().activated = !ResourcesManager.getInstance().activated;
	        	yesSel = new ScaleMenuItemDecorator(new SpriteMenuItem(YES, resourcesManager.yes, vbom), 1, 1);
	        	notSel = new ScaleMenuItemDecorator(new SpriteMenuItem(NOT, resourcesManager.not, vbom), 1, 1);
	        	if (ResourcesManager.getInstance().activated)
	        	{
	       	     	yesSel.setPosition(yesSel.getX() + 850 , yesSel.getY() - 75);
	       	     	notSel.setPosition(notSel.getX() + 950 , notSel.getY() - 75);
	       	     	notSel.setColor(Color.RED);
	       	     	yesSel.setColor(Color.WHITE);
	        		menuChildScene.addMenuItem(yesSel);
	        		menuChildScene.addMenuItem(notSel);
	        	}
	        	else
	        	{
	       	     	notSel.setPosition(notSel.getX() + 950 , notSel.getY() - 75);
	       	     	yesSel.setPosition(yesSel.getX() + 850 , yesSel.getY() - 75);
	       	     	yesSel.setColor(Color.RED);
	       	     	notSel.setColor(Color.WHITE);
	        		menuChildScene.addMenuItem(notSel);
	        		menuChildScene.addMenuItem(yesSel);
	        	}
	        	
	        	break;
	        	
	        case PARTICLE:
	        	
	        	ResourcesManager.getInstance().particlesActivated = !ResourcesManager.getInstance().particlesActivated;
	        	yesSel2 = new ScaleMenuItemDecorator(new SpriteMenuItem(YES, resourcesManager.yes, vbom), 1, 1);
	        	notSel2 = new ScaleMenuItemDecorator(new SpriteMenuItem(NOT, resourcesManager.not, vbom), 1, 1);
	        	ResourcesManager.getInstance().activated2 = !ResourcesManager.getInstance().activated2;
	        	if (ResourcesManager.getInstance().activated2)
	        	{
	       	     	yesSel2.setPosition(yesSel2.getX() + 850 , yesSel2.getY() - 130);
	       	     	notSel2.setPosition(notSel2.getX() + 950 , notSel2.getY() - 130);
	       	     	notSel2.setColor(Color.RED);
	       	     	yesSel2.setColor(Color.WHITE);
	        		menuChildScene.addMenuItem(yesSel2);
	        		menuChildScene.addMenuItem(notSel2);
	        	}
	        	else
	        	{
	       	     	notSel2.setPosition(notSel2.getX() + 950 , notSel2.getY() - 130);
	       	     	yesSel2.setPosition(yesSel2.getX() + 850 , yesSel2.getY() - 130);
	       	     	yesSel2.setColor(Color.RED);
	       	     	notSel2.setColor(Color.WHITE);
	        		menuChildScene.addMenuItem(notSel2);
	        		menuChildScene.addMenuItem(yesSel2);
	        	}
	        	
	        	break;
	            
	        default:
	         break;
	    }
		return true;
	}

	@Override
	public void disposeScene(int levelID)
	{
		
	}

}
