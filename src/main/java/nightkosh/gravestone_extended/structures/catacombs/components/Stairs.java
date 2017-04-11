package nightkosh.gravestone_extended.structures.catacombs.components;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.structures.BoundingBoxHelper;
import nightkosh.gravestone_extended.structures.catacombs.CatacombsLevel;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Stairs extends CatacombsBaseComponent {

    public static final int X_LENGTH = 5;
    public static final int HEIGHT = 16;
    public static final int Z_LENGTH = 13;

    public Stairs(EnumFacing facing, int level, Random random, int x, int y, int z) {
        super(0, facing, level);
        Passage entrance = new Passage(this, 0, 0, 0);

        this.setEntrance(entrance);
        this.addRequiredExit(new Passage(this, 0, 0, Z_LENGTH, ComponentSide.FRONT, true));

        boundingBox = BoundingBoxHelper.getCorrectBox(facing, x, y - HEIGHT + 4, z, X_LENGTH, HEIGHT, Z_LENGTH, entrance);
    }

    /**
     * Build component
     */
    @Override
    public boolean addComponentParts(World world, Random random) {
        BlockSelector stoneBricks = getCemeteryCatacombsStones();
        IBlockState netherBrickStairsBotState = Blocks.NETHER_BRICK_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, this.getCoordBaseMode().getOpposite());

        int top = boundingBox.maxY - boundingBox.minY - 1;
        int shiftY;
        int shiftZ;
        this.fillWithBlocks(world, boundingBox, 0, top + 1, 0, 4, top + 1, 0, netherBrick);

        for (int i = 0; i < 3; i++) {
            shiftZ = i * 4;
            shiftY = top - i * 4 + 1;
            this.fillWithAir(world, boundingBox, 1, shiftY - 4, shiftZ, 3, shiftY - 1, shiftZ + 1);
            this.fillWithAir(world, boundingBox, 1, shiftY - 5, shiftZ + 1, 3, shiftY - 2, shiftZ + 2);
            this.fillWithAir(world, boundingBox, 1, shiftY - 6, shiftZ + 2, 3, shiftY - 3, shiftZ + 3);
            this.fillWithAir(world, boundingBox, 1, shiftY - 7, shiftZ + 3, 3, shiftY - 4, shiftZ + 4);

            // nether walls
            this.fillWithBlocks(world, boundingBox, 0, shiftY - 4, shiftZ, 0, shiftY, shiftZ, netherBrick);
            this.fillWithBlocks(world, boundingBox, 4, shiftY - 4, shiftZ, 4, shiftY, shiftZ, netherBrick);

            // block walls
            this.fillWithRandomizedBlocks(world, boundingBox, 0, shiftY - 5, shiftZ + 1, 0, shiftY - 1, shiftZ + 1, false, random, stoneBricks);
            this.fillWithRandomizedBlocks(world, boundingBox, 4, shiftY - 5, shiftZ + 1, 4, shiftY - 1, shiftZ + 1, false, random, stoneBricks);
            this.fillWithRandomizedBlocks(world, boundingBox, 0, shiftY - 6, shiftZ + 2, 0, shiftY - 2, shiftZ + 2, false, random, stoneBricks);
            this.fillWithRandomizedBlocks(world, boundingBox, 4, shiftY - 6, shiftZ + 2, 4, shiftY - 2, shiftZ + 2, false, random, stoneBricks);
            this.fillWithRandomizedBlocks(world, boundingBox, 0, shiftY - 7, shiftZ + 3, 0, shiftY - 3, shiftZ + 3, false, random, stoneBricks);
            this.fillWithRandomizedBlocks(world, boundingBox, 4, shiftY - 7, shiftZ + 3, 4, shiftY - 3, shiftZ + 3, false, random, stoneBricks);

            // nether stairs
            this.fillWithBlocks(world, boundingBox, 1, shiftY - 4, shiftZ, 3, shiftY - 4, shiftZ, netherBrickStairsBotState);
            this.fillWithBlocks(world, boundingBox, 1, shiftY - 5, shiftZ + 1, 3, shiftY - 5, shiftZ + 1, netherBrickStairsBotState);
            this.fillWithBlocks(world, boundingBox, 1, shiftY - 6, shiftZ + 2, 3, shiftY - 6, shiftZ + 2, netherBrickStairsBotState);
            this.fillWithBlocks(world, boundingBox, 1, shiftY - 7, shiftZ + 3, 3, shiftY - 7, shiftZ + 3, netherBrickStairsBotState);

            Block stairsBlock = CatacombsLevel.getCatacombsStairsByLevelId(this.level);
            IBlockState stairsTopState = stairsBlock.getDefaultState().withProperty(BlockStairs.FACING, this.getCoordBaseMode())
                    .withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.TOP);

            // block stairs
            this.fillWithBlocks(world, boundingBox, 1, shiftY - 1, shiftZ + 1, 3, shiftY - 1, shiftZ + 1, stairsTopState);
            this.fillWithBlocks(world, boundingBox, 1, shiftY - 2, shiftZ + 2, 3, shiftY - 2, shiftZ + 2, stairsTopState);
            this.fillWithBlocks(world, boundingBox, 1, shiftY - 3, shiftZ + 3, 3, shiftY - 3, shiftZ + 3, stairsTopState);
            this.fillWithBlocks(world, boundingBox, 1, shiftY - 4, shiftZ + 4, 3, shiftY - 4, shiftZ + 4, stairsTopState);

            // web
            this.randomlyFillWithBlocks(world, boundingBox, random, 0.2F, 1, shiftY - 3, shiftZ, 1, shiftY - 3, shiftZ, Blocks.WEB.getDefaultState(), false);
            this.randomlyFillWithBlocks(world, boundingBox, random, 0.2F, 3, shiftY - 3, shiftZ + 1, 3, shiftY - 3, shiftZ + 1, Blocks.WEB.getDefaultState(), false);
            this.randomlyFillWithBlocks(world, boundingBox, random, 0.2F, 2, shiftY - 5, shiftZ + 2, 2, shiftY - 5, shiftZ + 2, Blocks.WEB.getDefaultState(), false);
            this.randomlyFillWithBlocks(world, boundingBox, random, 0.2F, 3, shiftY - 5, shiftZ + 3, 3, shiftY - 5, shiftZ + 3, Blocks.WEB.getDefaultState(), false);
        }

        this.fillWithBlocks(world, boundingBox, 0, 0, Z_LENGTH - 1, 4, 0, Z_LENGTH - 1, netherBrick);
        this.fillWithRandomizedBlocks(world, boundingBox, 0, 0, Z_LENGTH - 1, 0, 4, Z_LENGTH - 1, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 4, 0, Z_LENGTH - 1, 4, 4, Z_LENGTH - 1, false, random, stoneBricks);
        return true;
    }
}