package google.com.dynamicjson.model;

import java.util.List;

/**
 * Created by Ashok on 12/20/2018.
 */

public class ExampleDynamic {

    private String OptionGroupName, OptionGroupId;
    private int OptionCount;
    private List<Options> optionsList=null;

    public String getOptionGroupName() {
        return OptionGroupName;
    }

    public void setOptionGroupName(String optionGroupName) {
        OptionGroupName = optionGroupName;
    }

    public String getOptionGroupId() {
        return OptionGroupId;
    }

    public void setOptionGroupId(String optionGroupId) {
        OptionGroupId = optionGroupId;
    }

    public int getOptionCount() {
        return OptionCount;
    }

    public void setOptionCount(int optionCount) {
        OptionCount = optionCount;
    }

    public List<Options> getOptionsList() {
        return optionsList;
    }

    public void setOptionsList(List<Options> optionsList) {
        this.optionsList = optionsList;
    }

    public static class Options {
        String OptionGroupId, OptionGroupName, ProductId, OptionId, OptionName, OptionPrice, IsActive;

        public String getOptionGroupId() {
            return OptionGroupId;
        }

        public void setOptionGroupId(String optionGroupId) {
            OptionGroupId = optionGroupId;
        }

        public String getOptionGroupName() {
            return OptionGroupName;
        }

        public void setOptionGroupName(String optionGroupName) {
            OptionGroupName = optionGroupName;
        }

        public String getProductId() {
            return ProductId;
        }

        public void setProductId(String productId) {
            ProductId = productId;
        }

        public String getOptionId() {
            return OptionId;
        }

        public void setOptionId(String optionId) {
            OptionId = optionId;
        }

        public String getOptionName() {
            return OptionName;
        }

        public void setOptionName(String optionName) {
            OptionName = optionName;
        }

        public String getOptionPrice() {
            return OptionPrice;
        }

        public void setOptionPrice(String optionPrice) {
            OptionPrice = optionPrice;
        }

        public String getIsActive() {
            return IsActive;
        }

        public void setIsActive(String isActive) {
            IsActive = isActive;
        }

        @Override
        public String toString() {
            return "***{" +
                    "***='" + OptionGroupId + '\'' +
                    ", ***='" + OptionGroupName + '\'' +
                    ", ***='" + ProductId + '\'' +
                    ", ***='" + OptionId + '\'' +
                    ", ***='" + OptionName + '\'' +
                    ", ***='" + OptionPrice + '\'' +
                    ", ***='" + IsActive + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "***{" +
                "***='" + OptionGroupName + '\'' +
                ", ***='" + OptionGroupId + '\'' +
                ", ***=" + OptionCount +
                ", ***=" + optionsList +
                '}';
    }
}
