INSERT INTO categorie (nume, descriere) VALUES
('Greutati si Bare', 'Gantere, discuri olimpice, bare si kettlebell-uri'),
('Aparate Cardio', 'Benzi de alergat, biciclete fitness si eliptice'),
('Accesorii Antrenament', 'Benzi elastice, centuri haltere, manusi si covorase');

INSERT INTO produs (nume, descriere, pret, stoc, categorie_id) VALUES
('Banda de alergat ProFit 500', 'Motor 3.5 CP, viteza pana la 20 km/h, inclinatie automata', 3499.00, 5,
 (SELECT id FROM categorie WHERE nume = 'Aparate Cardio')),
('Bicicleta stationara MagneticRide', 'Volanta 9 kg, 16 trepte de rezistenta', 1299.99, 12,
 (SELECT id FROM categorie WHERE nume = 'Aparate Cardio')),
('Set Gantere Reglabile 40kg', '2 gantere reglabile de la 5 la 40 kg cu suport inclus', 1450.00, 8,
 (SELECT id FROM categorie WHERE nume = 'Greutati si Bare')),
('Haltera Olimpica 20kg', 'Otel cromat, lungime 220cm, capacitate 450kg', 650.00, 15,
 (SELECT id FROM categorie WHERE nume = 'Greutati si Bare')),
('Disc Cauciucat Bumper 10kg', 'Diametru standard 450mm, orificiu 50mm', 180.00, 40,
 (SELECT id FROM categorie WHERE nume = 'Greutati si Bare')),
('Centura Piele Powerlifting', 'Grosime 10mm, catarama solida din otel', 199.90, 20,
 (SELECT id FROM categorie WHERE nume = 'Accesorii Antrenament')),
('Set 5 Benzi Elastice Latex', 'Niveluri diferite de rezistenta cu saculet de transport', 79.00, 0,
 (SELECT id FROM categorie WHERE nume = 'Accesorii Antrenament'));
