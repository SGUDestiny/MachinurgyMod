package destiny.deimachinae.init;

import destiny.deimachinae.DeiMachinaeMod;
import destiny.deimachinae.blocks.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static destiny.deimachinae.blocks.IncenseBurnerBlock.LIT;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DeiMachinaeMod.MODID);

    public static final RegistryObject<Block> OMNISSIAN_ALTAR = registerBlock("omnissian_altar", () -> new OmnissianAltarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(5.0F).sound(SoundType.COPPER).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> HEATER_FURNACE = registerBlock("heater_furnace", () -> new HeaterFurnace(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(5.0F).sound(SoundType.COPPER).requiresCorrectToolForDrops().lightLevel((state) -> state.getValue(LIT) ? 14 : 0)));
    public static final RegistryObject<Block> COLUMN_BOILER = registerBlock("column_boiler", () -> new ColumnBoilerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(5.0F).sound(SoundType.COPPER).requiresCorrectToolForDrops().noOcclusion().lightLevel((state) -> state.getValue(LIT) ? 10 : 0)));

    public static final RegistryObject<Block> ANCIENT_CRYPT = BLOCKS.register("ancient_crypt", () -> new AncientCryptBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(5.0F).sound(SoundType.COPPER).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> IMPERIAL_AQUILA = BLOCKS.register("imperial_aquila", () -> new HorizontalWallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(2.0F).sound(SoundType.COPPER).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> COG_MECHANICUM = BLOCKS.register("cog_mechanicum", () -> new HorizontalWallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(2.0F).sound(SoundType.COPPER).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> INCENSE_BURNER = BLOCKS.register("incense_burner", () -> new IncenseBurnerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(2.0F).sound(SoundType.LANTERN).requiresCorrectToolForDrops().noOcclusion().lightLevel((state) -> state.getValue(LIT) ? 5 : 0)));

    public static final RegistryObject<Block> ARCHEOBRASS_BLOCK = registerBlock("archeobrass_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(3.0F).sound(SoundType.COPPER).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SCRAP_PILE = registerBlock("scrap_pile", () -> new FallingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(4.0F).sound(SoundType.ANCIENT_DEBRIS).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> NOCTILITH_ORE = registerBlock("noctilith_ore", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(5.0F).sound(SoundType.GILDED_BLACKSTONE).requiresCorrectToolForDrops().explosionResistance(1000)));

    public static final RegistryObject<LiquidBlock> CELESTIAL_OIL = BLOCKS.register("celestial_oil",
            () -> new LiquidBlock(FluidInit.SOURCE_CELESTIAL_OIL, BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));

    public static final RegistryObject<Block> OIL_COKE_BLOCK = BLOCKS.register("oil_coke_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 6.0F)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
