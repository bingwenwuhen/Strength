package cn.com.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/8/3.
 */
public class lambda5 {

    public static void main(String[] args) {
        List<Asset> assets = Arrays.asList(
                new Asset(Asset.AssetType.BOND, 30),
                new Asset(Asset.AssetType.STOCK, 4000)
        );
        System.out.println(totalAssetValues(assets));
    }

    public static int totalAssetValues(final List<Asset> assets) {
        return assets.stream()
                .mapToInt(Asset::getValue)
                .sum();
    }

    public static int totalBoundValues(final List<Asset> assets) {
        return assets.stream()
                .mapToInt(asset -> asset.getType() == Asset.AssetType.BOND?asset.getValue():0)
                .sum();
    }

    public static int totalBoundValues2(final List<Asset> assets) {
        return assets.stream()
                .filter(asset -> asset.getType() == Asset.AssetType.BOND)
                .mapToInt(Asset::getValue)
                .sum();
    }
}
