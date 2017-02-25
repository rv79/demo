import { MangosearchWebappPage } from './app.po';

describe('mangosearch-webapp App', () => {
  let page: MangosearchWebappPage;

  beforeEach(() => {
    page = new MangosearchWebappPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
