class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor = image[sr][sc];
        if (startColor == color) return image;

        int rows = image.length;
        int cols = image[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});

        while (!queue.isEmpty()) {
            int[] pixel = queue.remove();
            int r = pixel[0], c = pixel[1];
            image[r][c] = color;

            if (r > 0 && image[r - 1][c] == startColor) // up 
                queue.add(new int[]{r - 1, c});

            if (r < rows - 1 && image[r + 1][c] == startColor) // down 
                queue.add(new int[]{r + 1, c});

            if (c > 0 && image[r][c - 1] == startColor)   // left
                queue.add(new int[]{r, c - 1});

            if (c < cols - 1 && image[r][c + 1] == startColor)  //right
                queue.add(new int[]{r, c + 1});
        }

        return image;
    }
}
