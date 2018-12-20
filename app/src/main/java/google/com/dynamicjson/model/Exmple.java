package google.com.dynamicjson.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ashok on 12/20/2018.
 */

public class Exmple {

    @SerializedName("***")
    @Expose
    private String optionGroupName;
    @SerializedName("***")
    @Expose
    private String optionGroupId;
    @SerializedName("***")
    @Expose
    private int optionCount;
    @SerializedName("***")
    @Expose
    private List<Option> options = null;

    public String getOptionGroupName() {
        return optionGroupName;
    }

    public void setOptionGroupName(String optionGroupName) {
        this.optionGroupName = optionGroupName;
    }

    public String getOptionGroupId() {
        return optionGroupId;
    }

    public void setOptionGroupId(String optionGroupId) {
        this.optionGroupId = optionGroupId;
    }

    public int getOptionCount() {
        return optionCount;
    }

    public void setOptionCount(int optionCount) {
        this.optionCount = optionCount;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }


    public class Option {

        @SerializedName("***")
        @Expose
        private String optionGroupId;
        @SerializedName("***")
        @Expose
        private String optionGroupName;
        @SerializedName("***")
        @Expose
        private String productId;
        @SerializedName("***")
        @Expose
        private String optionId;
        @SerializedName("***")
        @Expose
        private String optionName;
        @SerializedName("***")
        @Expose
        private String optionPrice;
        @SerializedName("***")
        @Expose
        private String isActive;

        public String getOptionGroupId() {
            return optionGroupId;
        }

        public void setOptionGroupId(String optionGroupId) {
            this.optionGroupId = optionGroupId;
        }

        public String getOptionGroupName() {
            return optionGroupName;
        }

        public void setOptionGroupName(String optionGroupName) {
            this.optionGroupName = optionGroupName;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getOptionId() {
            return optionId;
        }

        public void setOptionId(String optionId) {
            this.optionId = optionId;
        }

        public String getOptionName() {
            return optionName;
        }

        public void setOptionName(String optionName) {
            this.optionName = optionName;
        }

        public String getOptionPrice() {
            return optionPrice;
        }

        public void setOptionPrice(String optionPrice) {
            this.optionPrice = optionPrice;
        }

        public String getIsActive() {
            return isActive;
        }

        public void setIsActive(String isActive) {
            this.isActive = isActive;
        }

        @Override
        public String toString() {
            return "***{" +
                    "***='" + optionGroupId + '\'' +
                    ", ***='" + optionGroupName + '\'' +
                    ", ***='" + productId + '\'' +
                    ", ***='" + optionId + '\'' +
                    ", ***='" + optionName + '\'' +
                    ", ***='" + optionPrice + '\'' +
                    ", ***='" + isActive + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "***{" +
                "***='" + optionGroupName + '\'' +
                ", ***='" + optionGroupId + '\'' +
                ", ***=" + optionCount +
                ", ***=" + options +
                '}';
    }
}
