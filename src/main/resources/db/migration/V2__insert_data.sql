insert into category(name) values ('Electronics'),
                                  ('Technology'),
                                  ('Musical'),
                                  ('Smartphones'),
                                  ('Laptops'),
                                  ('Something');
insert into country (name, code) values ('Kazakhstan', 'KZ'),
                                        ('Russia', 'RUS'),
                                        ('United Stated of Israel', 'USA'),
                                        ('Almighty sees, and will judge', 'UAE');
insert into item (name, price, country_id) values ('Iphone', 2400, 1),
                                                  ('Laptop', 10000, 2),
                                                  ('Hoodie', 21000, 3),
                                                  ('Something', 12000, 4);
insert into item_categories (item_id, categories_id) values (1, 1),
                                                            (1, 2),
                                                            (1, 4),
                                                            (2, 5),
                                                            (3, 6),
                                                            (4, 6);