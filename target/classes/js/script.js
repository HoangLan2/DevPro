$('#open_sidebar').on('click', function (event) {
    // ghi đè sự kiện của event cha
    event.stopPropagation();
    // lấy giá trị của thuộc tính css left
    var left_sidebar = $('nav').css('left');
    if (left_sidebar == '-470px') {
        $('nav').css('left', '320px');
    } else {
        $('nav').css('left', '320px');
    }
});

$(document).on('click', function (event) {
    var obj = $('nav');
    if (!obj.is(event.target) && obj.has(event.target).length === 0) {
        $('nav').css('left', '320px');
    }
});

// $('a').on('click', function (event) {
//     // ghi đè sự kiện html mặc định
//     event.preventDefault();
//     alert('ghi đè sự kiện default của thẻ html');
// });

$('.carousel').carousel({
    interval: 2000
  })



  $('input.input-qty').each(function() {
    var $this = $(this),
      qty = $this.parent().find('.is-form'),
      min = Number($this.attr('min')),
      max = Number($this.attr('max'))
    if (min == 0) {
      var d = 0
    } else d = min
    $(qty).on('click', function() {
      if ($(this).hasClass('minus')) {
        if (d > min) d += -1
      } else if ($(this).hasClass('plus')) {
        var x = Number($this.val()) + 1
        if (x <= max) d += 1
      }
      $this.attr('value', d).val(d)
    })
  })


$(document).ready(function () {
            $('.your-class').slick({
                slidesToShow: 3,
                slidesToScroll: 1,
                autoplay: true,
                autoplaySpeed: 2000,
                prevArrow: $('.btnPre'),
                nextArrow: $('.btnNext'),
            });
        });

$(document).ready(function () {
            $('.slick-slider').slick({
                centerMode: true,
                centerPadding: '60px',
                slidesToShow: 3,
                prevArrow: $('.btnPre'),
                nextArrow: $('.btnNext'),
            });
        });
  