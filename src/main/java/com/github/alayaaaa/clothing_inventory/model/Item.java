package com.github.alayaaaa.clothing_inventory.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ITEMS")
public class Item {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String category;
        private String size;
        private int quantity;

        // No-argument constructor for JPA
        public Item() {}

        public Item(String name, String category, String size, int quantity) {

            this.name = name;
            this.category = category;
            this.size = size;
            this.quantity = quantity;

        }

        public Long getId() {

            return id;

        }

        public String getCategory() {

            return category;

        }

        public void setCategory(String category) {

            this.category = category;

        }

        public String getName() {

            return name;

        }

        public void setName(String name) {

            this.name = name;

        }

        public String getSize() {

            return size;

        }

        public void setSize(String size) {

            this.size = size;

        }

        public int getQuantity() {

            return quantity;

        }

        public void setQuantity(int quantity) {

            this.quantity = quantity;

        }

}
