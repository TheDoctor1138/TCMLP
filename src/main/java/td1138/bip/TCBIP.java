package td1138.bip;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import td1138.bip.core.CommonProxy;
import td1138.bip.entities.trains.EntityLocoDieselClass74;
import td1138.bip.recipes.TCBIPRecipeHandler;
import td1138.bip.common.library.TCBIPInfo;
import td1138.bip.entities.trains.EntityLocoElectricCStockEngine;
import td1138.bip.items.TCBIPItems;
import train.common.api.AbstractTrains;
import train.common.core.CreativeTabTraincraft;
import train.common.core.handlers.CraftingHandler;
import train.common.entity.rollingStock.EntityPassenger2;
import train.common.items.ItemRollingStock;
import train.common.library.TraincraftRegistry;

@Mod(modid = TCBIP.MODID, version = TCBIP.MOD_VERSION, name = "TCBIP",dependencies = "required-after:tc")
public class TCBIP {

	public static final String MODID = "tcbip";
	public static final String MOD_VERSION = "0.1_beta";
	public static CreativeTabTraincraft tabBIP;


	@Mod.Instance(MODID)
	public static TCBIP instance;

	@SidedProxy(clientSide = "td1138.bip.core.ClientProxy", serverSide = "td1138.bip.core.CommonProxy")
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {

		tabBIP = new CreativeTabTraincraft("B.I.P.", TCBIPInfo.modID, "trains/bipLogo");
		TraincraftRegistry.registerTransports("", listSteamTrains());
		TraincraftRegistry.registerTransports("", listFreight());
		TraincraftRegistry.registerTransports("", listPassenger());
		TraincraftRegistry.registerTransports("", listTanker());
		TraincraftRegistry.registerTransports("", listElectricTrains());
		TraincraftRegistry.registerTransports("", listDieselTrains());
		TraincraftRegistry.registerTransports("", listTender());

		TCBIPItems.init();
		TCBIPRecipeHandler.init();

		/* GUI handler initiation */
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);
		FMLCommonHandler.instance().bus().register(new CraftingHandler());

	}


	public static AbstractTrains[] listElectricTrains() {
		return new AbstractTrains[]{
			new EntityLocoElectricCStockEngine(null),

		};
	}

	public static AbstractTrains[] listDieselTrains() {
		return new AbstractTrains[]{new EntityLocoDieselClass74(null)};
	}
	public static AbstractTrains[] listSteamTrains() {

		return new AbstractTrains[]{};
	}

	public static AbstractTrains[] listPassenger() {

		return new AbstractTrains[]{};
	}

	public static AbstractTrains[] listFreight() {

		return new AbstractTrains[]{};
	}

	public static AbstractTrains[] listTanker() {

		return new AbstractTrains[]{};
	}

	public static AbstractTrains[] listTender() {

		return new AbstractTrains[]{};
	}
}
