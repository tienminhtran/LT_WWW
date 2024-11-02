

package vn.edu.iuh.fit.week03_lab.fontend.models;

import jakarta.json.*;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.week03_lab.backend.dtos.ProductDTO;
import vn.edu.iuh.fit.week03_lab.backend.repositories.entities.Product;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;


public class ProductModel {
    private final String ADD_URL = "http://localhost:8080/week03_lab-1.0-SNAPSHOT/api/products";

    public void createProduct(Product product) {
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(ADD_URL);

            Response response = target.request().post(Entity.json(product));
            if (response.getStatus() == Response.Status.CREATED.getStatusCode()) {
                System.out.println("Product added successfully");
            } else {
                System.out.println("Failed to add product");
            }
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> productDTOs = new ArrayList<>();
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(ADD_URL);

            Response response = target.request().accept("application/json").get();

            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                String jsonResponse = response.readEntity(String.class);
                System.out.println("Response JSON: " + jsonResponse);

                try (JsonReader jsonReader = Json.createReader(new StringReader(jsonResponse))) {
                    JsonArray jsonArray = jsonReader.readArray();
                    for (JsonValue jsonValue : jsonArray) {
                        JsonObject jsonObject = (JsonObject) jsonValue;
                        ProductDTO productDTO = new ProductDTO();
                        productDTO.setName(jsonObject.getString("name"));
                        productDTO.setDescription(jsonObject.getString("description"));
                        productDTO.setImgPath(jsonObject.getString("imgPath"));
                        productDTO.setPrice(jsonObject.getJsonNumber("price").doubleValue());
                        productDTOs.add(productDTO);
                    }
                }
            } else {
                System.out.println("Failed to retrieve products, status code: " + response.getStatus());
            }
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productDTOs;
    }

    public ProductDTO getProductById(int id) {
        ProductDTO productDTO = new ProductDTO();
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(ADD_URL + "/" + id);

            Response response = target.request().accept("application/json").get();

            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                String jsonResponse = response.readEntity(String.class);
                System.out.println("Response JSON: " + jsonResponse);

                try (JsonReader jsonReader = Json.createReader(new StringReader(jsonResponse))) {
                    JsonObject jsonObject = jsonReader.readObject();
                    productDTO.setId(jsonObject.getInt("id"));
                    productDTO.setName(jsonObject.getString("name"));
                    productDTO.setDescription(jsonObject.getString("description"));
                    productDTO.setImgPath(jsonObject.getString("imgPath"));
                    productDTO.setPrice(jsonObject.getJsonNumber("price").doubleValue());
                }
            } else {
                System.out.println("Failed to retrieve product, status code: " + response.getStatus());
            }
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productDTO;
    }
}
