package com.sillyhat.swing.module.container.middle;

import javax.swing.*;
import java.awt.*;

public class SillyHatTabPanel extends JPanel{

	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -3083158849745153721L;

	/** 
	 * @Fields panelCode : panel唯一ID 
	 */ 
	

	public SillyHatTabPanel(String panelCode){
		initService();//业务初始化Service
		setName(panelCode);
	}

	public void initService(){

	}

	public void debugFrame(Color color){
		setBorder(BorderFactory.createLineBorder(color));
	}
}
