package test.codeavengers.util;

import java.util.ArrayList;
import java.util.List;

import org.codeavengers.common.dto.RestWrapper;
import org.codeavengers.common.dto.entity.Category;
import org.codeavengers.common.dto.entity.LocationCategoryAssn;
import org.codeavengers.common.dto.entity.LocationMaster;
import org.codeavengers.common.dto.wrap.CategoryWrapper;
import org.codeavengers.common.dto.wrap.LocationWrapper;

public class ObjectMockingUtility {
    protected RestWrapper createCategoryRest() {
        RestWrapper wrapper = new RestWrapper();
        wrapper.setData(this.createCategoryWrapperDeep());
        wrapper.setDataList(this.createCategoryWrappers());
        wrapper.setError("Code", "Message");
        wrapper.setErrStack("Exception");
        return wrapper;
    }

    protected RestWrapper createLocationRest() {
        RestWrapper wrapper = new RestWrapper();
        wrapper.setData(this.createLocationWrapperDeep());
        wrapper.setDataList(this.createLocationWrappers());
        wrapper.setError("Code", "Message");
        wrapper.setErrStack("Exception");
        return wrapper;
    }

    protected LocationMaster createLocation() {
        LocationMaster location = new LocationMaster();
        location.setArea("Hyderabad");
        location.setCode("HYD");
        location.setLat("27.00000");
        location.setLon("27.00000");
        return location;
    }

    protected LocationMaster createLocationDeep() {
        LocationMaster location = this.createLocation();
        Category category = this.createCategory();

        this.createAssociationRelation(location, category);
        return location;
    }

    protected LocationWrapper createLocationWrapper() {
        LocationWrapper wrapper = new LocationWrapper();
        wrapper.setArea("Hyderabad");
        wrapper.setCode("HYD");
        wrapper.setLat("27.00000");
        wrapper.setLon("27.00000");
        wrapper.setValue("28912");
        wrapper.setUnit("No. of Persons");
        return wrapper;
    }

    protected LocationWrapper createLocationWrapperDeep() {
        LocationWrapper wrapper = this.createLocationWrapper();
        wrapper.setCates(this.createCategoryWrappers());
        return wrapper;
    }

    protected List<LocationWrapper> createLocationWrappers() {
        List<LocationWrapper> wrappers = new ArrayList<LocationWrapper>(1);
        wrappers.add(this.createLocationWrapper());
        return wrappers;
    }

    protected Category createCategory() {
        Category category = new Category();
        category.setCatDesc("Accidents");
        return category;
    }

    protected Category createCategoryDeep() {
        LocationMaster location = this.createLocation();
        Category category = this.createCategory();

        this.createAssociationRelation(location, category);
        return category;
    }

    protected CategoryWrapper createCategoryWrapper() {
        CategoryWrapper wrapper = new CategoryWrapper();
        wrapper.setCatDesc("Accidents");
        wrapper.setValue("28912");
        wrapper.setUnit("No. of Persons");
        return wrapper;
    }

    protected CategoryWrapper createCategoryWrapperDeep() {
        CategoryWrapper wrapper = this.createCategoryWrapper();
        wrapper.setLocns(this.createLocationWrappers());
        return wrapper;
    }

    protected List<CategoryWrapper> createCategoryWrappers() {
        List<CategoryWrapper> wrappers = new ArrayList<CategoryWrapper>(1);
        wrappers.add(this.createCategoryWrapper());
        return wrappers;
    }

    protected LocationCategoryAssn createAssociation() {
        LocationCategoryAssn assn = new LocationCategoryAssn();
        assn.setCategoryField("No. of Persons");
        assn.setCategoryValue("28912");
        return assn;
    }

    protected List<LocationCategoryAssn> createAssociations() {
        List<LocationCategoryAssn> assns = new ArrayList<LocationCategoryAssn>(1);
        assns.add(this.createAssociation());
        return assns;
    }

    protected List<LocationCategoryAssn> createAssociationRelation(LocationMaster location, Category category) {
        List<LocationCategoryAssn> assns = this.createAssociations();
        assns.get(0).setCategory(category);
        assns.get(0).setLocation(location);

        location.setAssns(assns);
        category.setAssns(assns);

        return assns;
    }
}
