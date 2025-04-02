package repository;

import repository.custom.impl.CustomerDaoImpl;
import repository.custom.impl.ItemDaoImpl;
import util.DaoType;

public class DaoFactroy {

    private static DaoFactroy instance;

    private DaoFactroy(){}

    public static DaoFactroy getInstance(){

        return instance == null ? instance=new DaoFactroy():instance;

    }

    public <T extends SuperDao> T getDaoTyyple(DaoType type){

        switch (type){
            case CUSTOMER :return (T) new CustomerDaoImpl();
            case ITEM:return (T) new ItemDaoImpl();

        }

        return null;
    }

}
