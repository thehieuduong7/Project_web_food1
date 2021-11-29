// $(document).on("click", "#btnPlus", function() {  // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
//     $.get("testAjaxServlet", function(responseJson) {    // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
//         var $span = $("<span>").appendTo($(".totalSingle")); // Create HTML <ul> element and append it to HTML DOM element with ID "somediv".
//         $.each(responseJson, function(index, item) { // Iterate over the JSON array.
//             $("<span>").text(item).appendTo($span);      // Create HTML <li> element, set its text content with currently iterated item and append it to the <ul>.
//         });
//     });
// });
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
// // const bindProductEvents = () => {
// //     $('button.increase').on('click', (e) => {
// //         increaseProductQuantity(e.currentTarget);
// //     });
// //
// //     $('button.decrease').on('click', (e) => {
// //         subtractProductQuantity(e.currentTarget);
// //     });
// //
// //     $('a.remove-product').on('click', (e) => {
// //         removeProduct(e.currentTarget);
// //     });
// // }
// //
// // const increaseProductQuantity = (product) => {
// //     const productId = $(product).parents('.product').get(0).id
// //     const price = $.grep(productsInCart, el => { return el.id == productId })[0].price;
// //
// //     $.each(storageData, (i, el) => {
// //         if (el.id == productId) {
// //             el.itemsNumber += 1
// //             $(product).siblings('.quantity').val(el.itemsNumber);
// //             $(`#${productId}`).find('.price').html(`$${(price * el.itemsNumber).toFixed(2)}`);
// //             $(`#${productId}-dropdown`).find('.price').html(`$${(price * el.itemsNumber).toFixed(2)}`);
// //         }
// //     });
// //
// //     updateCart();
// // }
// //
// // const subtractProductQuantity = (product) => {
// //     const productId = $(product).parents('.product').get(0).id
// //     const price = $.grep(productsInCart, el => { return el.id == productId })[0].price;
// //     let itemsInCart = $.grep(productsInCart, el => { return el.id == productId })[0].itemsNumber;
// //
// //     if (itemsInCart > 0) {
// //         storageData.map(el => {
// //             if (el.id == productId) {
// //                 el.itemsNumber -= 1
// //                 $(product).siblings('.quantity').val(el.itemsNumber)
// //                 $(`#${productId}`).find('.price').html(`$${(price * el.itemsNumber).toFixed(2)}`);
// //                 $(`#${productId}-dropdown`).find('.price').html(`$${(price * el.itemsNumber).toFixed(2)}`);
// //             }
// //         });
// //         updateCart();
// //     };
// // }
// //
// // const updateProductList = () => {
// //     $('#product-list').empty();
// //     buildProductList();
// //     $('#dropdown-cart').empty();
// //     buildDropdownCart();
// //     bindProductEvents();
// // }
//
//
//
//
// // const removeProduct = (product) => {
// //     const productId = $(product).parents('.product').get(0).id
// //
// //     storageData = $.grep(storageData, (el, i) => {
// //         return el.id != productId
// //     });
// //
// //     updateCart();
// //     updateProductList();
// // }
//
// // $('.add-to-cart').on('click', (e) => {
// //     addToCart(e.currentTarget)
// // })
//
// // $(document).ready(() => {
// //     let storageData = [];
// //
// //     $.get("product.json", (res) => {
// //         productList = res;
// //
// //         const isStorageEmpty = Cookies.getStorage('cart').length === 0;
// //
// //         if (!isStorageEmpty) {
// //             storageData = Cookies.getStorage('cart');
// //         }
// //
// //         updateCart();
// //         buildProductList();
// //         buildDropdownCart();
// //         bindProductEvents();
// //     });
// // });
//
// // const updateCart = () => {
// //     Cookies.setStorage('cart', storageData);
// //     productsInCart = [];
// //
// //     parseStorageDataWithProduct();
// //     updatePill();
// //     updateTotalAmount();
// // }
//
// // const parseStorageDataWithProduct = () => {
// //     $.each(storageData, (i, el) => {
// //         const id = el.id;
// //         const itemsNumber = el.itemsNumber;
// //
// //         $.each(productList, (i, el) => {
// //             if (id == el.id) {
// //                 el.itemsNumber = itemsNumber;
// //                 productsInCart.push(el)
// //             }
// //         });
// //     });
// // }
//
// // const updatePill = () => {
// //     let itemsInCart = 0;
// //
// //     $.each(productsInCart, (i, el) => {
// //         itemsInCart += el.itemsNumber;
// //     });
// //
// //     $('.badge-pill').html(itemsInCart);
// // }
//
// // const updateTotalAmount = () => {
// //     let total = 0;
// //     const shippingCost = 0;
// //     let summary = (total + shippingCost).toFixed(2);
// //
// //     $.each(productsInCart, (i, el) => {
// //         total += el.itemsNumber * el.price;
// //     });
// //
// //     $('#total-price').html(`$${total.toFixed(2)}`);
// //     $('#shipping-price').html(shippingCost === 0 ? 'Free' : `$${shippingCost}`);
// //     $('#summary').html(`$${summary}`);
// // }
//
// // const addToCart = (product) => {
// //     const productId = $(product).attr('productId');
// //     const isAlreadyInCart = $.grep(productsInCart, el => { return el.id == productId }).length;
// //
// //     if (isAlreadyInCart) {
// //         $.each(storageData, (i, el) => {
// //             if (productId == el.id) {
// //                 el.itemsNumber += 1;
// //             }
// //         })
// //     } else {
// //         const newProduct = {
// //             id: Number(productId),
// //             itemsNumber: 1
// //         }
// //
// //         storageData.push(newProduct);
// //     }
// //
// //     updateCart();
// //     updateProductList();
// // }
//
// // const buildProductList = () => {
// //     $.each(productsInCart, (i, el) => {
// //         const product = renderProducts(el)
// //         $('#product-list').append(product);
// //     })
// // }
//
// // const buildDropdownCart = () => {
// //     $.each(productsInCart, (i, el) => {
// //         const product = renderDropdownProducts(el);
// //         $('#dropdown-cart').append(product)
// //     })
// // }