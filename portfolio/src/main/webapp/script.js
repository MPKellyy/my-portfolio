// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Generates a URL for a random image in the images directory and adds an img
 * element with that URL to the page (specifically for schedify).
 */
function randomizeImage1() {
  // The images directory contains 4 images, so generate a random index between
  // 1 and 4.
  const imageIndex = Math.floor(Math.random() * 4) + 1;
  const imgUrl = 'images/schedify-' + imageIndex + '.png';

  const imgElement = document.createElement('img');
  imgElement.src = imgUrl;

  const imageContainer = document.getElementById('random-image-container1');
  // Remove the previous image.
  imageContainer.innerHTML = '';
  imageContainer.appendChild(imgElement);
}

/**
 * Generates a URL for a random image in the images directory and adds an img
 * element with that URL to the page (specifically for ITN-SelfSearch).
 */
function randomizeImage2() {
  // The images directory contains 4 images, so generate a random index between
  // 1 and 4.
  const imageIndex = Math.floor(Math.random() * 4) + 1;
  const imgUrl = 'images/ITN-SelfSearch-' + imageIndex + '.png';

  const imgElement = document.createElement('img');
  imgElement.src = imgUrl;

  const imageContainer = document.getElementById('random-image-container2');
  // Remove the previous image.
  imageContainer.innerHTML = '';
  imageContainer.appendChild(imgElement);
}
