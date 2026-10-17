Bagian C 
itur Analitik findStrongest

Method yang dirancang
Method findStrongest() ditambahkan di class CharacterManager. Method ini mencari karakter dengan nilai attack tertinggi dari semua karakter yang tersimpan, lalu mengembalikannya sebagai satu objek Character. Jika belum ada karakter, method mengembalikan null.

Alasan memilih method ini
Di class Character, nilai attack dihitung dari level (10 + (level - 1) * 5), sehingga karakter dengan level tinggi otomatis punya attack tinggi. Karena itu pertanyaan "siapa karakter terkuat" adalah analisis yang wajar untuk sebuah manager. Method countByType() hanya menghitung jumlah, sedangkan findStrongest() membandingkan data antar karakter. Logikanya ditaruh di CharacterManager, bukan di Main, karena manager yang memegang daftar karakter. Main cukup memanggil method tanpa perlu tahu cara pencariannya.

Penerapan Encapsulation
1. List characters bersifat private final, sehingga tidak bisa diakses atau diganti dari luar class. findStrongest() hanya membaca list dan tidak mengubah isinya.
2. Method tidak mengembalikan ArrayList asli, sejalan dengan getAllCharacters() yang juga mengembalikan salinan list.
3. Method juga tidak mengembalikan objek Character asli yang ada di dalam list. Karena Character punya setter publik seperti setLevel() dan setName(), jika objek aslinya dikembalikan maka kode di luar bisa mengubah data di dalam manager. Karena itu method membuat salinan dengan constructor new Character(nama, tipe, level). Hit point dan attack tidak perlu disalin karena dihitung otomatis oleh setLevel() di dalam constructor. Hanya nilai mana yang disalin terpisah dengan setMana().

Penanganan kasus khusus
a. Jika list kosong, method mengembalikan null agar tidak terjadi error saat mengambil characters.get(0).
b. Jika ada dua karakter dengan attack yang sama, karakter yang lebih dulu ditambahkan yang terpilih, karena perbandingan memakai tanda > bukan >=.

Javadoc
Method dilengkapi Javadoc yang menjelaskan fungsinya, bahwa hasilnya berupa salinan, dan nilai kembaliannya (@return).

Pengujian
Di Main, findStrongest() dipanggil setelah Robin dihapus. Hasilnya Merlin (level 5, attack 30), yang lebih kuat dari Arthas (level 1, attack 10). Level salinan kemudian diubah menjadi 99, tetapi level Merlin di dalam manager tetap 5, sehingga terbukti objek asli tidak ikut berubah. Pada CharacterManager yang kosong, method mengembalikan null.



BAGIAM D LINK GGOGLE DOCS [https://docs.google.com/document/d/1nm3JSOj4oQlJd0jupqna7yOGfCXycAS69TShWrSU1JY/edit?usp=sharing]