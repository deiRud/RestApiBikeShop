PGDMP      0                 }            online_bike_shop    16.6    16.6     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    24941    online_bike_shop    DATABASE     �   CREATE DATABASE online_bike_shop WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'German_Germany.1252';
     DROP DATABASE online_bike_shop;
                postgres    false            �            1259    24972    images    TABLE     �   CREATE TABLE public.images (
    image_id integer NOT NULL,
    hashcolor character varying(10),
    model_color character varying(50)
);
    DROP TABLE public.images;
       public         heap    postgres    false            �            1259    24971    images_image_id_seq    SEQUENCE     �   CREATE SEQUENCE public.images_image_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.images_image_id_seq;
       public          postgres    false    218            �           0    0    images_image_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.images_image_id_seq OWNED BY public.images.image_id;
          public          postgres    false    217            �            1259    24956    products    TABLE     <  CREATE TABLE public.products (
    product_id integer NOT NULL,
    category character varying(100),
    brand character varying(50) NOT NULL,
    model character varying(100) NOT NULL,
    specifications text,
    price numeric(6,2) NOT NULL,
    imageurl character varying(100),
    color character varying(10)
);
    DROP TABLE public.products;
       public         heap    postgres    false            �            1259    24955    product_product_id_seq    SEQUENCE     �   CREATE SEQUENCE public.product_product_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.product_product_id_seq;
       public          postgres    false    216            �           0    0    product_product_id_seq    SEQUENCE OWNED BY     R   ALTER SEQUENCE public.product_product_id_seq OWNED BY public.products.product_id;
          public          postgres    false    215            V           2604    24975    images image_id    DEFAULT     r   ALTER TABLE ONLY public.images ALTER COLUMN image_id SET DEFAULT nextval('public.images_image_id_seq'::regclass);
 >   ALTER TABLE public.images ALTER COLUMN image_id DROP DEFAULT;
       public          postgres    false    217    218    218            U           2604    24959    products product_id    DEFAULT     y   ALTER TABLE ONLY public.products ALTER COLUMN product_id SET DEFAULT nextval('public.product_product_id_seq'::regclass);
 B   ALTER TABLE public.products ALTER COLUMN product_id DROP DEFAULT;
       public          postgres    false    216    215    216            �          0    24972    images 
   TABLE DATA           B   COPY public.images (image_id, hashcolor, model_color) FROM stdin;
    public          postgres    false    218   h       �          0    24956    products 
   TABLE DATA           n   COPY public.products (product_id, category, brand, model, specifications, price, imageurl, color) FROM stdin;
    public          postgres    false    216   �       �           0    0    images_image_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.images_image_id_seq', 1, false);
          public          postgres    false    217            �           0    0    product_product_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.product_product_id_seq', 9, true);
          public          postgres    false    215            Z           2606    24977    images images_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.images
    ADD CONSTRAINT images_pkey PRIMARY KEY (image_id);
 <   ALTER TABLE ONLY public.images DROP CONSTRAINT images_pkey;
       public            postgres    false    218            X           2606    24963    products product_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.products
    ADD CONSTRAINT product_pkey PRIMARY KEY (product_id);
 ?   ALTER TABLE ONLY public.products DROP CONSTRAINT product_pkey;
       public            postgres    false    216            �      x������ � �      �   \  x���[o�0��ç�X�+����A��d&M�4".ɖ�ï��KF����zr�c�d���NT��0\�4/
U&J�A��0Su��J&"��,F?���Ed10���PE���%�	'>������;��!�:�O��]��	�T�C�y��*ea>�f�']�n��'з���wΆ���8�y\���:�;��#����<@�`�x] ���k:r���v�HH�	~E��܆[a�#�aL���j�*�G�z���S<��F��BJUUy�͖�� ��)�#-Ӧ��u�2���xajm���s��Pd���u��T��a��I��7+�]wH���9��sS��r�ہ�8����     