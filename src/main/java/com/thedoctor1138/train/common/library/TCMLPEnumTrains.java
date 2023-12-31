package com.thedoctor1138.train.common.library;

import net.minecraft.item.Item;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import train.common.api.AbstractTrains;
import train.common.api.TrainRecord;
import train.common.core.util.TraincraftUtil;
import com.thedoctor1138.train.common.entity.rollingStock.*;
import train.common.entity.rollingStock.EntityPassengerSNCB_M6;
import train.common.library.ItemIDs;


import java.lang.reflect.InvocationTargetException;

public enum TCMLPEnumTrains implements TrainRecord {
	
	//Ctyrk4 Pack

	NMBS_HLE_18("NMBS_HLE_18", EntityLocoElectricNMBS_HLE_18.class, TCMLPItemIDs.minecartNMBS_HLE_18.item, "electric", 6705, 201, 0, 10, 0, 0, 0.9, 0.79, 0, TraincraftUtil.getBytesFromColors(new String[]{"White", "Grey"}), 10, -3.7, "Pack: B.I.P."),
	EurofimaPresidentiale("EuroFimaPresidentiale", EntityPassengerEuroFimaPresidentiale.class, TCMLPItemIDs.minecartEuroFirmaPresidentiale.item, "passenger", 0, 0, 3.0,0 , 0, 0, 0,0,0,null,0,-11, "Pack: WWCP"),


	;

//String trainType,int MHP,int maxSpeed, double mass, int fuelConsumption, int waterConsumption, int heatingTime, double accelerationRate, double brakeRate, int tankCapacity, String[] colors,

	private String internalName;
	private Class entityClass;
	private Item item;
	private String trainType;
	private int MHP;
	private int maxSpeed;
	private double mass;
	private int fuelConsumption;
	private int waterConsumption;
	private int heatingTime;
	private double accelerationRate;
	private double brakeRate;
	private int tankCapacity;
	private int[] colors;
	private int guiRenderScale;
	private double bogieLocoPosition;
	private String additionalTooltip;
	private int cargoCapacity;
	
	/**
	 * 
	 * @param internalName : Only used by EntityRegistry
	 * @param entityClass
	 * @param item
	 * @param trainType: "steam", "diesel", "freight", "passenger", "special", "flat", "electric"
	 * @param MHP: power of the locomotive
	 * @param maxSpeed
	 * @param mass (will be multiplied by 10 internally. That means putting 0.1 here will create a mass of 1 Ton in game)
	 * @param fuelConsumption: 1 unit is consumed every x ticks
	 * @param waterConsumption: 1 unit is consumed every x ticks
	 * @param heatingTime
	 * @param accelerationRate: generally around 0.45
	 * @param brakeRate: generally around 0.98
	 * @param tankCapacity
	 * @param colors: an array with all possible colors. Index 0 is used as default color when train is first spawned. leave null if no color available
	 * @param guiRenderScale: scale at which the entity will be rendered inside the GUI (crafting GUI)
	 */
	private TCMLPEnumTrains(String internalName, Class entityClass, Item item, String trainType, int MHP, int maxSpeed, double mass, int fuelConsumption, int waterConsumption, int heatingTime, double accelerationRate, double brakeRate, int tankCapacity, int[] colors, int guiRenderScale, double bogieLocoPosition){
		this.internalName = internalName;
		this.entityClass = entityClass;
		this.item = item;
		this.trainType=trainType;
		this.MHP=MHP;
		this.maxSpeed=maxSpeed;
		this.mass=mass;
		this.fuelConsumption=fuelConsumption;
		this.waterConsumption=waterConsumption;
		this.heatingTime=heatingTime;
		this.accelerationRate=accelerationRate;
		this.brakeRate=brakeRate;
		this.tankCapacity=tankCapacity;
		this.colors=colors;
		this.guiRenderScale = guiRenderScale;
		this.bogieLocoPosition = bogieLocoPosition;
	}
	
	/**
	 * Constructor for additional tooltips on the item
	 * @param internalName
	 * @param entityClass
	 * @param item
	 * @param trainType
	 * @param MHP
	 * @param maxSpeed
	 * @param mass
	 * @param fuelConsumption
	 * @param waterConsumption
	 * @param heatingTime
	 * @param accelerationRate
	 * @param brakeRate
	 * @param tankCapacity
	 * @param colors
	 * @param guiRenderScale
	 * @param bogieLocoPositions
	 * @param additionalTooltip
	 */
	private TCMLPEnumTrains(String internalName, Class entityClass, Item item, String trainType, int MHP, int maxSpeed, double mass, int fuelConsumption, int waterConsumption, int heatingTime, double accelerationRate, double brakeRate, int tankCapacity, int[] colors, int guiRenderScale, double bogieLocoPositions, String additionalTooltip){
		this.internalName = internalName;
		this.entityClass = entityClass;
		this.item = item;
		this.trainType=trainType;
		this.MHP=MHP;
		this.maxSpeed=maxSpeed;
		this.mass=mass;
		this.fuelConsumption=fuelConsumption;
		this.waterConsumption=waterConsumption;
		this.heatingTime=heatingTime;
		this.accelerationRate=accelerationRate;
		this.brakeRate=brakeRate;
		this.tankCapacity=tankCapacity;
		this.colors=colors;
		this.guiRenderScale = guiRenderScale;
		this.bogieLocoPosition = bogieLocoPositions;
		this.additionalTooltip = additionalTooltip;
	}
	
	/**
	 * Constructor for freight carts
	 * @param internalName
	 * @param entityClass
	 * @param item
	 * @param trainType
	 * @param mass
	 * @param colors
	 * @param guiRenderScale
	 * //@param bogieLocoPositions
	 * //@param bogieUtilityPositions
	 * @param cargoCapacity
	 * @param additionalTooltip
	 */
	private TCMLPEnumTrains(String internalName, Class entityClass, Item item, String trainType, double mass, int[] colors, int guiRenderScale, int cargoCapacity, String additionalTooltip){
		this.internalName = internalName;
		this.entityClass = entityClass;
		this.item = item;
		this.trainType=trainType;
		this.mass=mass;
		this.colors=colors;
		this.guiRenderScale = guiRenderScale;
		this.additionalTooltip =additionalTooltip;
		this.cargoCapacity = cargoCapacity;
	}
	
    @Override
	public String getName(){
		return name();
	}
	
    @Override
	public String getInternalName(){
		return this.internalName;
	}
	
    @Override
	public Item getItem(){
		return this.item;
	}

    @Override
	public String getTrainType(){
		return this.trainType;
	}
	
    @Override
	public int getMHP(){
		return this.MHP;
	}
	
    @Override
	public int getMaxSpeed(){
		return this.maxSpeed;
	}
	
    @Override
	public double getMass(){
		return this.mass;
	}
	
    @Override
	public int getFuelConsumption(){
		return this.fuelConsumption;
	}
	
    @Override
	public int getWaterConsumption(){
		return this.waterConsumption;
	}
	
    @Override
	public int getHeatingTime(){
		return this.heatingTime;
	}
	
    @Override
	public double getAccelerationRate(){
		return this.accelerationRate;
	}
	
    @Override
	public double getBrakeRate(){
		return this.brakeRate;
	}
	
    @Override
	public int getTankCapacity(){
		return this.tankCapacity;
	}
	
    @Override
	public int[] getColors(){
		return this.colors;
	}
	
    @Override
	public double getBogieLocoPosition(){
		return this.bogieLocoPosition;
	}

    @Override
	public Class getEntityClass() {
		return this.entityClass;
	}
	
    @Override
	public int getGuiRenderScale(){
		return this.guiRenderScale;
	}
	
    @Override
	public String getAdditionnalTooltip(){
		return this.additionalTooltip;
	}
	
    @Override
	public int getCargoCapacity(){
		return cargoCapacity;
	}

    @Override
	public AbstractTrains getEntity(World world){
		try {
			return (AbstractTrains) entityClass.getConstructor(World.class).newInstance(world);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}
	
    @Override
	public AbstractTrains getEntity(World world, double x, double y, double z){
		try {
			if(world.isRemote){
				entityClass.getConstructor(World.class).newInstance(world);
			} else {
				return (AbstractTrains) entityClass.getConstructor(World.class, double.class, double.class, double.class).newInstance(world, x, y, z);
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static class Constants {
		public static final String TOOLTIP = "Pack: " + EnumChatFormatting.YELLOW + "Ctyrk4 Pack"  + EnumChatFormatting.GOLD + EnumChatFormatting.BOLD + "  -Petsox";
	}
}
