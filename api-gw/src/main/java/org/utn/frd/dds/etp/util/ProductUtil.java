package org.utn.frd.dds.etp.util;

import org.utn.frd.dds.etp.dto.RequestProductDTO;
import org.utn.frd.dds.etp.dto.ResponseProductDTO;
import org.utn.frd.dds.etp.entity.Product;

public class ProductUtil {

    public static Product getProduct(RequestProductDTO requestProductDTO) {

        Product product = new Product();

        product.setCode(requestProductDTO.getCode());

        return product;
    }

    public static ResponseProductDTO getResponseProductDTO(Product product) {

        ResponseProductDTO responseProductDTO = new ResponseProductDTO();
        responseProductDTO.setCode(product.getCode());
        responseProductDTO.setDescription(product.getDescription());

        return responseProductDTO;
    }
}
